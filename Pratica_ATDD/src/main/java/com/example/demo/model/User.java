package com.example.demo.model;

public class User {
    private String nome;
    private String email;
    private String senha;
    private double saldo = 0;
    
    private Role nivel_acesso = Role.USUARIO;

    public User(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // getters e setters
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double saldo) {
        this.saldo += saldo;
    }
    
    public void removerSaldo(double saldo) {
    	this.saldo -= saldo;
    }
    
    public Role getRole() {
    	return this.nivel_acesso;
    }
    
    public boolean temNivelAcesso(Role role) {
    	int roleIndex = role.ordinal();
    	int userRoleIndex = this.nivel_acesso.ordinal();
    			
    	return userRoleIndex >= roleIndex;
    }
    
    public boolean temSaldoSuficiente(double price) {
    	return this.saldo >= price;
    }
    
    public String assinarPlano(Plan plano) {
    	double planPrice = plano.getValor();
    	Role planRole = plano.getRole();
    	
    	if(this.temNivelAcesso(planRole)) return "Usuário já possui a assinatura da plataforma.";
    	
    	if(!this.temSaldoSuficiente(planPrice)) 
    		return "Usuário não tem saldo suficiente para assinatura do plano.";
    	
    	this.removerSaldo(planPrice);
    	this.nivel_acesso = planRole;
    	
    	return "Plano assinado com sucesso.";
    }

	public String[] getCatalogoCursos() {
		String[] userCatalogoCursos = new String[0];
		return userCatalogoCursos;
	}
}