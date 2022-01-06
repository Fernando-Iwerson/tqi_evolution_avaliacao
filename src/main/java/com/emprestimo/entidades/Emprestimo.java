package com.emprestimo.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    private Double valorEmprestimo;
    private String dataPrimeiraParcela;
    private int quantidadeParcelas;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoaEmprestimo;

    @OneToMany(mappedBy =  "emprestimo")
    private List<ParcelasEmprestimo> parcelasEmprestimos = new ArrayList<>();




    /**Construtor sem args*/
    public Emprestimo() {

    }

    /**
     *Construtor com argumentos  */
    public Emprestimo(Long idEmprestimo, Double valorEmprestimo, String dataPrimeiraParcela, int quantidadeParcelas, Pessoa pessoaEmprestimo, List<ParcelasEmprestimo> parcelasEmprestimos) {
        this.idEmprestimo = idEmprestimo;
        this.valorEmprestimo = valorEmprestimo;
        this.dataPrimeiraParcela = dataPrimeiraParcela;
        this.quantidadeParcelas = quantidadeParcelas;
        this.pessoaEmprestimo = pessoaEmprestimo;
        this.parcelasEmprestimos = parcelasEmprestimos;
    }

    /**
     *Getters and Setters da classe*/

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(Long idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(Double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public String getDataPrimeiraParcela() {
        return dataPrimeiraParcela;
    }

    public void setDataPrimeiraParcela(String dataPrimeiraParcela) {
        this.dataPrimeiraParcela = dataPrimeiraParcela;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public Pessoa getPessoa() {
        return pessoaEmprestimo;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoaEmprestimo = pessoa;
    }

    public List<ParcelasEmprestimo> getParcelasEmprestimos() {
        return parcelasEmprestimos;
    }

    public void setParcelasEmprestimos(List<ParcelasEmprestimo> parcelasEmprestimos) {
        this.parcelasEmprestimos = parcelasEmprestimos;
    }

    /**
     *equals da classe */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return quantidadeParcelas == that.quantidadeParcelas && Objects.equals(idEmprestimo, that.idEmprestimo) && Objects.equals(valorEmprestimo, that.valorEmprestimo) && Objects.equals(dataPrimeiraParcela, that.dataPrimeiraParcela) && Objects.equals(pessoaEmprestimo, that.pessoaEmprestimo) && Objects.equals(parcelasEmprestimos, that.parcelasEmprestimos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmprestimo, valorEmprestimo, dataPrimeiraParcela, quantidadeParcelas, pessoaEmprestimo, parcelasEmprestimos);
    }

    /**
     *toString da classe  */
    @Override
    public String toString() {
        return "Emprestimo{" +
                "idEmprestimo=" + idEmprestimo +
                ", valorEmprestimo=" + valorEmprestimo +
                ", dataPrimeiraParcela=" + dataPrimeiraParcela +
                ", quantidadeParcelas=" + quantidadeParcelas +
                ", pessoa=" + pessoaEmprestimo +
                ", parcelasEmprestimos=" + parcelasEmprestimos +
                '}';
    }
}
