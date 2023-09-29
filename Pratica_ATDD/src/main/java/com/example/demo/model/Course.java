package com.example.demo.model;

public class Course {
    private String nome;
    private String descricao;
    private Plan plano;

    public Course(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // getters and setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Plan getPlano() {
        return plano;
    }

    public void setPlano(Plan plano) {
        this.plano = plano;
    }
}