package driveSchoolAPI.com.redhat.driveSchoolAPIServer.rest;

import java.util.Date;

import driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain.Aluno;

public class AlunoBuilder {

	private String nome;
	private int idade;
	private int cpf;
	private String tipoCarta;
	private Date dataMatricula;
	
	
	public AlunoBuilder setNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public AlunoBuilder setIdade(int idade) {
		this.idade = idade;
		return this;
	}
	
	public AlunoBuilder setCpf(int cpf) {
		this.cpf = cpf;
		return this;
	}
	
	public AlunoBuilder setTipoCarta(String tipoCarta) {
		this.tipoCarta = tipoCarta;
		return this;
	}
	
	public AlunoBuilder setdataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
		return this;
	}
	
	
	public Aluno criaAluno() {
		return new Aluno(nome, idade,cpf, tipoCarta,dataMatricula);
	}
	
	
	
	
	
	
}
