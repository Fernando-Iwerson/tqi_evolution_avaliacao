package com.emprestimo.resources;

import com.emprestimo.entidades.Endereco;
import com.emprestimo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

    /**
     * Injeção de dependecia*/
    @Autowired
    private EnderecoService service;

    /**
     *Listar endereçõs*/
    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco> List = service.findAll();
        return ResponseEntity.ok().body(List);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id){
        Endereco obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Endereco> insert(@RequestBody Endereco obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getIdEndereco()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Endereco> update(@PathVariable Long id, @RequestBody Endereco obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
