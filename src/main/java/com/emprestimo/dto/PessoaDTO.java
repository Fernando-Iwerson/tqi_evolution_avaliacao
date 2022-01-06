package com.emprestimo.dto;


import com.emprestimo.entidades.Pessoa;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaDTO {

    private long idPessoa;
    private String nome;
    private String email;
    private String cpf;
    private Double renda;

    public PessoaDTO() {

    }

    public PessoaDTO(Pessoa pessoas) {
        this.idPessoa = pessoas.getIdPessoa();
        this.nome = pessoas.getNome();
        this.email = pessoas.getEmail();
        this.cpf = pessoas.getCpf();
        this.renda = pessoas.getRenda();
    }

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

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public static List<PessoaDTO> convert(List<Pessoa> pessoas){
        return pessoas.stream().map(PessoaDTO::new).collect(Collectors.toList());
    }
}
