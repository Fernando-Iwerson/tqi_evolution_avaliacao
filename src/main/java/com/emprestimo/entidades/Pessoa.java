package com.emprestimo.entidades;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPessoa;
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private Double renda;
    private String senha;

    @OneToMany(mappedBy = "pessoaEmprestimo")
    private List<Emprestimo> emprestimos = new ArrayList<>();

    @OneToMany(mappedBy =  "pessoaEndereco")
    private List<Endereco> enderecos  = new ArrayList<>();

    /**
     * Construtor sem argumentos*/
    public Pessoa() {
    }

    /**
     * Construtor com argumentos*/
    public Pessoa(long idPessoa, String nome, String email, String cpf, String rg, Double renda, String senha, List<Emprestimo> emprestimos, List<Endereco> enderecos) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.renda = renda;
        this.senha = senha;
        this.emprestimos = emprestimos;
        this.enderecos = enderecos;
    }

    /**
     * Getters and setters*/
    public long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    /**
     * equals da classe*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idPessoa == pessoa.idPessoa && Objects.equals(nome, pessoa.nome) && Objects.equals(email, pessoa.email) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(rg, pessoa.rg) && Objects.equals(renda, pessoa.renda) && Objects.equals(senha, pessoa.senha) && Objects.equals(emprestimos, pessoa.emprestimos) && Objects.equals(enderecos, pessoa.enderecos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, nome, email, cpf, rg, renda, senha, emprestimos, enderecos);
    }

    /**
     *toString da classe */
    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", renda=" + renda +
                ", senha='" + senha + '\'' +
                ", emprestimos=" + emprestimos +
                ", enderecos=" + enderecos +
                '}';
    }
}
