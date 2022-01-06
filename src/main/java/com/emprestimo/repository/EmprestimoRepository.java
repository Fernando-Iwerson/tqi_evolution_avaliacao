package com.emprestimo.repository;

import com.emprestimo.entidades.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {



}
