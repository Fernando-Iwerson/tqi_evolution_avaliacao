package com.emprestimo.repository;

import com.emprestimo.entidades.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {



}
