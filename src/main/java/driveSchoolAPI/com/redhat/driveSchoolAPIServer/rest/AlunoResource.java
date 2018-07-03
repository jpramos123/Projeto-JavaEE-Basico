package driveSchoolAPI.com.redhat.driveSchoolAPIServer.rest;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PostUpdate;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain.Aluno;
import driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain.Professor;
import driveSchoolAPI.com.redhat.driveSchoolAPIServer.infrastructure.AlunoRepository;
import driveSchoolAPI.com.redhat.driveSchoolAPIServer.infrastructure.ProfessorRepository;


@Path("/alunos")
public class AlunoResource {

	@EJB
	private AlunoRepository alunosRepository;

	@EJB
	private ProfessorRepository professoresRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTodosAlunos() {

		List<Aluno> alunos = alunosRepository.getTodosAlunos();
		GenericEntity<List<Aluno>> alunosWrapper = new GenericEntity<List<Aluno>>(alunos) {};
		return Response.ok(alunosWrapper).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvaAluno(final Aluno aluno, int cpfProfessor) {
		Aluno alunoSalvo = alunosRepository.salvaAluno(aluno);
		Professor professorDoAluno = professoresRepository.getByCpf(cpfProfessor).get();
		professorDoAluno.associaAluno(aluno);
		return Response.ok(alunoSalvo).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{cpfAluno}")
	public Response getAluno(@PathParam("cpfAluno")int cpf) {
		Optional<Aluno> aluno = alunosRepository.getByCpf(cpf);
		if(aluno.isPresent()) {
			return Response.ok(aluno.get()).build();
		}
		return Response.noContent().build();
	}

}
