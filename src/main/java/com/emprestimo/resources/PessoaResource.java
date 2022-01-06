package com.emprestimo.resources;

import com.emprestimo.dto.PessoaDTO;
import com.emprestimo.entidades.Pessoa;
import com.emprestimo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    /**
     * Injeção de dependecia*/
    @Autowired
    private PessoaService service;

    /**
     *Listar todas as pessoas*/
    @GetMapping
    public ResponseEntity<List<PessoaDTO>> findAll(){
        List<PessoaDTO> pessoaDTOS = service.findAll();
        return ResponseEntity.ok().body(pessoaDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id){
        Pessoa obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/login")
    public void logar(String email, String senha){
        String sql = "select * from tb_pessoa a where a.email = ? and a.senha= ?";
        Connection conexao = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try{
            pst =  conexao.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, senha);
            // Queru executada
            rs = pst.executeQuery();

            if (rs.next()){
                System.out.println("Usuario logado");
            }else{
                System.out.println("Usuario não encontrado");
            }

        } catch (Exception e){

        }
    }

    @PostMapping
    public ResponseEntity<Pessoa> insert(@RequestBody Pessoa obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getIdPessoa()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}
