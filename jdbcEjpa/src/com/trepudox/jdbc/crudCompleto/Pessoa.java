package com.trepudox.jdbc.crudCompleto;

import java.time.LocalDate;

public class Pessoa {
    private Long id;
    private String nome;
    private LocalDate dataNasc;
    private String cidade;

    public Pessoa() {}

    public Pessoa(String nome, LocalDate dataNasc, String cidade) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cidade = cidade;
    }

    public Pessoa(Long id, String nome, LocalDate dataNasc, String cidade) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return String.format("%03d     %-15.15s\t" + dataNasc + "\t\t%s", id, nome, cidade);
    }
}
