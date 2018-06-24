package driveSchoolAPI.com.redhat.driveSchoolAPIServer.rest;

import driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain.Professor;

public class ProfessorBuilder {


	private String nome;
	private int cpf;
	private int idade;
	
	
	public ProfessorBuilder setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public ProfessorBuilder setCpf(int cpf) {
		this.cpf = cpf;
		return this;
	}

	public ProfessorBuilder setIdade(int idade) {
		this.idade = idade;
		return this;
	}


	public Professor criaProfessor() {
		return new Professor (nome, cpf, idade);
	}
	
	
	
}
