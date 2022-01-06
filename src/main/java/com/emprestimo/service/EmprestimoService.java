package com.emprestimo.service;

import com.emprestimo.entidades.Emprestimo;
import com.emprestimo.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    public List<Emprestimo> findAll(){
        return repository.findAll();
    }

    public Emprestimo findById(Long id){
        Optional<Emprestimo> obj = repository.findById(id);
        return obj.get();
    }



    /**
     *Metodo insert de emprestimo*/
    public Emprestimo insert(Emprestimo obj){
        return repository.save(obj);
    }

    /**
     * Delete*/
    public void delete(Long id){
        repository.deleteById(id);
    }

    /**
     * update*/
    public Emprestimo update(Long id, Emprestimo obj){
        Emprestimo entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }


    private void updateData(Emprestimo entity, Emprestimo obj) {
        entity.setValorEmprestimo(obj.getValorEmprestimo());
        entity.setDataPrimeiraParcela(obj.getDataPrimeiraParcela());
        entity.setQuantidadeParcelas(obj.getQuantidadeParcelas());
        entity.setPessoa(obj.getPessoa());
    }


}
