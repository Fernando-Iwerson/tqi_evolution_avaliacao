package com.emprestimo.resources;

import com.emprestimo.entidades.ParcelasEmprestimo;
import com.emprestimo.entidades.Pessoa;
import com.emprestimo.service.ParcelasEmprestimoService;
import com.emprestimo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/parcelaemprestimos")
public class ParcelaEmprestimoResource {

    /**
     * Injeção de dependecia*/
    @Autowired
    private ParcelasEmprestimoService service;

    /**
     *Listar todas as parcelas*/
    @GetMapping
    public ResponseEntity<List<ParcelasEmprestimo>> findAll(){
        List<ParcelasEmprestimo> List = service.findAll();
        return ResponseEntity.ok().body(List);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ParcelasEmprestimo> findById(@PathVariable Long id){
        ParcelasEmprestimo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<ParcelasEmprestimo> insert(@RequestBody ParcelasEmprestimo obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getIdParcela()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ParcelasEmprestimo> update(@PathVariable Long id, @RequestBody ParcelasEmprestimo obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
