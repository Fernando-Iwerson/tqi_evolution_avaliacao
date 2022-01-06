package com.emprestimo.service;

import com.emprestimo.entidades.Endereco;
import com.emprestimo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    /**
     * get all*/
    public List<Endereco> findAll(){
        return repository.findAll();
    }

    /**
     * get por id*/
    public Endereco findById(Long id){
        Optional<Endereco> obj = repository.findById(id);
        return obj.get();
    }

    /**
     *Metodo insert de pessoa*/
    public Endereco insert(Endereco obj){
        return repository.save(obj);
    }

    /**
     * Delete*/
    public void delete(Long id){
        repository.deleteById(id);
    }

    /**
     * update*/
    public Endereco update(Long id, Endereco obj){
        Endereco entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Endereco entity, Endereco obj) {
        entity.setUf(obj.getUf());
        entity.setCidade(obj.getCidade());
        entity.setBairro(obj.getBairro());
        entity.setRua(obj.getRua());
        entity.setNumero(obj.getNumero());
        entity.setPessoaEndereco(obj.getPessoaEndereco());
    }

}
