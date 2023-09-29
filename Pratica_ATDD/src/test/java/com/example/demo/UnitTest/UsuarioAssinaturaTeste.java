package com.example.demo.UnitTest;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


import org.junit.Test;

import com.example.demo.model.User;
import com.example.demo.model.Course;
import com.example.demo.model.Plan;
import com.example.demo.model.School;
import com.example.demo.model.Role;

public class UsuarioAssinaturaTeste {

	// BDD - Todos
	@Test
	public void deveLiberarAcessoAoUsuario() {
		// Cenários
		School escolaOnline = new School("Escola de Programação do Deaque");
		Plan planoBasico = new Plan("Plano básico de programação", Role.ASSINANTE, 23.90);	
		User joao = new User("João Perinpinpin", "jperinpinpin@gpin.com", "senha123");
		
		// Execução
		escolaOnline.adicionarPlano(planoBasico);
		joao.adicionarSaldo(30);
		joao.assinarPlano(planoBasico);
		
		// Resultados
		assertEquals(Role.ASSINANTE, joao.getRole());
	}

	//BDD - Integrante 1
	@Test
	public void naoDeveRealizarAssinaturaCasoSaldoInsuficiente(){
		// Cenários
		School escolaOnline = new School("Escola de Programação do Deaque");
		Plan planoBasico = new Plan("Plano básico de programação", Role.ASSINANTE, 200);	
		User joao = new User("João Perinpinpin", "jperinpinpin@gpin.com", "senha123");

		// Execução
		escolaOnline.adicionarPlano(planoBasico);
		joao.adicionarSaldo(30);
		
		String mensagemRetorno = joao.assinarPlano(planoBasico);
		
		// Resultados
		assertEquals(Role.USUARIO, joao.getRole());
		assertEquals("Usuário não tem saldo suficiente para assinatura do plano.", mensagemRetorno);
		assertEquals(30.0, joao.getSaldo(),0.00001);
	}
	
	//BDD - Integrante 2

	@Test
	public void deveBloquearCasoSejaTentativaDuplicada() {

		// Cenários
		School escolaOnline = new School("Escola de Programação do Deaque");
		Plan planoBasico = new Plan("Plano básico de programação", Role.ASSINANTE, 23.90);	
		User ze = new User("Zezin", "ze@ze.com", "senha123");
		
		double saldoInicial = 50.0;
		String mensagemRetorno = "";
		
		// Execução
		ze.adicionarSaldo(saldoInicial);
		escolaOnline.adicionarPlano(planoBasico);
		mensagemRetorno = ze.assinarPlano(planoBasico);
		
		escolaOnline.adicionarPlano(planoBasico);
		mensagemRetorno = ze.assinarPlano(planoBasico);

		// Resultados
		assertEquals("Usuário já possui a assinatura da plataforma.", mensagemRetorno);
		assertEquals(saldoInicial - planoBasico.getValor(), ze.getSaldo(),0.00001);
	}

	//BDD - Integrante 3
	@Test
	public void deveExibirCursosDaCategoriaDeAssinatura() {
		// Cenários
		School escolaOnline = new School("Escola de Programação do Deaque");
		
		Plan planoBasico = new Plan("Plano básico de programação", Role.ASSINANTE, 23.90);
		Plan planoPremium = new Plan("Plano premium de programação", Role.ASSINANTE_PREMIUM, 54.90);
		
		Course cursoPython = new Course("Python: do básico ao avançado", "Curso de python...");
		Course cursoJavascript = new Course("Javascript: do básico ao avançado", "Curso de javascript...");
		Course cursoNodeJS = new Course("NodeJS avançado com Streams e Promises", "Curso de NodeJS...");
		
		User joao = new User("João Perinpinpin", "jperinpinpin@gpin.com", "senha123");
		
		// Execução
		planoBasico.adicionarCurso(cursoPython);
		planoBasico.adicionarCurso(cursoJavascript);
		planoPremium.adicionarCurso(cursoNodeJS);
				
		escolaOnline.adicionarPlano(planoBasico);
		joao.adicionarSaldo(30.0);
		joao.assinarPlano(planoBasico);
		
		String[] nomeCursosJoao = {cursoPython.getNome(),cursoJavascript.getNome()};
		
		// Resultados
		assertArrayEquals(nomeCursosJoao, joao.getCatalogoCursos());		
	}
}
