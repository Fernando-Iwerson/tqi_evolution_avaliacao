package com.emprestimo.service;


import com.emprestimo.dto.PessoaDTO;
import com.emprestimo.entidades.Emprestimo;
import com.emprestimo.entidades.Pessoa;
import com.emprestimo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository  repository;

    /**
     * Metodo para solicitar emprestimo*/
    public void solicitaEmprestimo(String valor, String dataParcela, String parcelas ){
        Emprestimo emprestimo = new Emprestimo();

    }

    /**
     * get all*/
    public List<PessoaDTO> findAll(){
        List<Pessoa> pessoas = repository.findAll();
        return PessoaDTO.convert(pessoas);// repository.findAll();
    }


    /**
     * get por id*/
    public Pessoa findById(Long id){
        Optional<Pessoa> obj = repository.findById(id);
        return obj.get();
    }



    /**
     *Metodo insert de pessoa*/
    public Pessoa insert(Pessoa obj){
        return repository.save(obj);
    }

    /**
     * Delete*/
    public void delete(Long id){
        repository.deleteById(id);
    }


    /**
     * update*/
    public Pessoa update(Long id, Pessoa obj){
        Pessoa entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }


    private void updateData(Pessoa entity, Pessoa obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setCpf(obj.getCpf());
        entity.setRg(obj.getRg());
        entity.setRenda(obj.getRenda());
    }

}
