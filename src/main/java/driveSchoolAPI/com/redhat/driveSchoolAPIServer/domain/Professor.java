package driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Professor implements Serializable{

	public Professor() {}
	
	
	
	public Professor(String nome, int cpf, int idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}



	private String nome;
	private int cpf;
	private int idade;
	private List<Aluno> alunos = new ArrayList<>();
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public List<Aluno> getAlunos() {
		return alunos;
	}
	public void associaAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	
	
}
