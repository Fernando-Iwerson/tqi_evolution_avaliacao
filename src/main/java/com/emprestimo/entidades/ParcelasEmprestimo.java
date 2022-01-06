package com.emprestimo.entidades;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_parcelaemprestimo")
public class ParcelasEmprestimo {
    /**
     * Atributos da classe*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParcela;
    private Date dataVencimento;
    private String observacao;

    @ManyToOne
    @JoinColumn(name = "idEmprestimo")
    private Emprestimo emprestimo;


    /**
     * Construtor sem argumentos*/
    public ParcelasEmprestimo() {

    }

    /**
     * Construtor com argumentos*/
    public ParcelasEmprestimo(Long idParcela, Date dataVencimento, String observacao, Emprestimo emprestimo) {
        this.idParcela = idParcela;
        this.dataVencimento = dataVencimento;
        this.observacao = observacao;
        this.emprestimo = emprestimo;
    }

    /**
     * Getters and setters*/
    public Long getIdParcela() {
        return idParcela;
    }

    public void setIdParcela(Long idParcela) {
        this.idParcela = idParcela;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
    }

    /**
     * equals da classe*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParcelasEmprestimo that = (ParcelasEmprestimo) o;
        return Objects.equals(idParcela, that.idParcela) && Objects.equals(dataVencimento, that.dataVencimento)
                && Objects.equals(observacao, that.observacao) && Objects.equals(emprestimo, that.emprestimo);
    }

    /**
     *hashCode da classe */
    @Override
    public int hashCode() {
        return Objects.hash(idParcela, dataVencimento, observacao, emprestimo);
    }

    /**
     * toString da classe*/
    @Override
    public String toString() {
        return "ParcelasEmprestimo{" +
                "idParcela=" + idParcela +
                ", dataVencimento=" + dataVencimento +
                ", observacao='" + observacao + '\'' +
                ", emprestimo=" + emprestimo +
                '}';
    }
}
