package com.emprestimo.service;

import com.emprestimo.entidades.Emprestimo;
import com.emprestimo.entidades.ParcelasEmprestimo;
import com.emprestimo.entidades.Pessoa;
import com.emprestimo.repository.ParcelasEmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ParcelasEmprestimoService {

    @Autowired
    ParcelasEmprestimoRepository repository;

    /**
     * get all*/
    public List<ParcelasEmprestimo> findAll(){
        return repository.findAll();
    }

    /**
     * get por id*/
    public ParcelasEmprestimo findById(Long id){
        Optional<ParcelasEmprestimo> obj = repository.findById(id);
        return obj.get();
    }

    /**
     *Metodo insert de pessoa*/
    public ParcelasEmprestimo insert(ParcelasEmprestimo obj){
        return repository.save(obj);
    }

    /**
     * Delete*/
    public void delete(Long id){
        repository.deleteById(id);
    }

    /**
     * update*/
    public ParcelasEmprestimo update(Long id, ParcelasEmprestimo obj){
        ParcelasEmprestimo entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }


    private void updateData(ParcelasEmprestimo entity, ParcelasEmprestimo obj) {
        entity.setDataVencimento(obj.getDataVencimento());
        entity.setObservacao(obj.getObservacao());
        entity.setEmprestimo(obj.getEmprestimo());

    }

}
