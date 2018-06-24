package driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aluno implements Serializable{

	
	public Aluno (){}
	
	
	
	public Aluno(String nome, int idade, int cpf, String tipoCarta, Date dataMatricula) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.tipoCarta = tipoCarta;
		this.dataMatricula = dataMatricula;
	}



	private String nome;
	private int idade;
	private int cpf;
	private String tipoCarta;
	private Date dataMatricula;
	
	
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

	public String getTipoCarta() {
		return tipoCarta;
	}
	public void setTipoCarta(String tipoCarta) {
		this.tipoCarta = tipoCarta;
	}
	
	public Date getDataMatricula() {
		return dataMatricula;
	}
	
	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Aluno aluno = (Aluno) obj;
		return Objects.equals(nome, aluno.getNome()) && Objects.equals(cpf, aluno.getCpf());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	
	@Override
	public String toString() {
		return "Aluno{"
				+ "Nome= " + nome
				+ "Idade= " + idade
				+ "CPF= " + cpf
				+ "Data Matriculo= " + dataMatricula
				+ "Tipo Carta= " + tipoCarta
				+ "}";
	}
	
}
