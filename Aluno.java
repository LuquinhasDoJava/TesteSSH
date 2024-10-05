package com.example.demo;

import java.time.LocalDate;

public class Aluno {
    private long id;
    private String ra;
    private String nome;
    private LocalDate nascimento;

    public String getNome() {
        return nome;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public long getId() {
        return id;
    }

    public String getRa() {
        return ra;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }


}
