package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Plan {
	private String nome;
	private double preco;
	
	private Role nivel_acesso;
	private List<Course> cursos = new ArrayList<Course>();
	
	public Plan(String nome, Role nivel_acesso, double preco) {
        this.nome = nome;
        this.nivel_acesso = nivel_acesso;
        this.preco = preco;
    }
	
	public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Course> getCursos() {
        return cursos;
    }
    
    public boolean adicionarCurso(Course curso) {
        return this.cursos.add(curso);
    }
    
    public boolean removerCurso(Course curso) {
    	return this.cursos.remove(curso);
    }
    
    public Double getValor() {
    	return this.preco;
    }
    
    public Role getRole() {
    	return this.nivel_acesso;
    }
}
