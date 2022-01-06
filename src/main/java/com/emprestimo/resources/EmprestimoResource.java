package com.emprestimo.resources;

import com.emprestimo.entidades.Emprestimo;
import com.emprestimo.entidades.Pessoa;
import com.emprestimo.service.EmprestimoService;
import com.emprestimo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/emprestimos")
public class EmprestimoResource {

    /**
     * Injeção de dependecia*/
    @Autowired
    private EmprestimoService service;

    /**
     *Listar os emprestimos*/
    @GetMapping
    public ResponseEntity<List<Emprestimo>> findAll(){
        List<Emprestimo> List = service.findAll();
        return ResponseEntity.ok().body(List);
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> findById(@PathVariable Long id){
        Emprestimo obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * iii. Solicitação de empréstimo
     *     Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas.
     *     O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.*/
    @PostMapping
    public ResponseEntity<Emprestimo> insert( @RequestBody Emprestimo obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getIdEmprestimo()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Emprestimo> update(@PathVariable Long id, @RequestBody Emprestimo obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
