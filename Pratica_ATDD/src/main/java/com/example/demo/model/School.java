package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class School {
    private String nome;
    private List<Plan> planos = new ArrayList<Plan>();

    public School(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Plan> getPlanos() {
        return planos;
    }

    public void adicionarPlano(Plan plano) {
        planos.add(plano);
    }
}
