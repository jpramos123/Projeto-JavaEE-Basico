package driveSchoolAPI.com.redhat.driveSchoolAPIServer.infrastructure;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import driveSchoolAPI.com.redhat.driveSchoolAPIServer.rest.AlunoBuilder;
import driveSchoolAPI.com.redhat.driveSchoolAPIServer.rest.ProfessorBuilder;


@Singleton
@Startup
public class Polula {

	@EJB
	private ProfessorRepository professorRepository;

	@EJB
	private AlunoRepository alunoRepository;


	@PostConstruct
	public void populaTudo() {

		DateFormat formatoData = new SimpleDateFormat("dd-MM-yyyy");

		professorRepository.salvaProfessor(
				new ProfessorBuilder()
				.setNome("Jose")
				.setCpf(123)
				.setIdade(28)
				.criaProfessor());

		professorRepository.salvaProfessor(
				new ProfessorBuilder()
				.setNome("Carlos")
				.setCpf(456)
				.setIdade(25)
				.criaProfessor());

		professorRepository.salvaProfessor(
				new ProfessorBuilder()
				.setNome("Maria")
				.setCpf(789)
				.setIdade(26)
				.criaProfessor());

		try {
			professorRepository.getByCpf(789).get()
			.associaAluno(
			alunoRepository.salvaAluno(
					new AlunoBuilder()
					.setNome("Joao")
					.setCpf(1122)
					.setIdade(18)
					.setdataMatricula(formatoData.parse("22-02-2018"))
					.setTipoCarta("A")
					.criaAluno()));
			
			professorRepository.getByCpf(789).get()
			.associaAluno(
			alunoRepository.salvaAluno(
					new AlunoBuilder()
					.setNome("Josue")
					.setCpf(2233)
					.setIdade(19)
					.setdataMatricula(formatoData.parse("21-04-2018"))
					.setTipoCarta("A")
					.criaAluno()));

		}
		catch (ParseException e) {
			System.out.println("Exception accours " + e);
		}
	
	}


}
