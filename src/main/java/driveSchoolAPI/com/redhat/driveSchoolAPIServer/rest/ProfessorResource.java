package driveSchoolAPI.com.redhat.driveSchoolAPIServer.rest;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain.Professor;
import driveSchoolAPI.com.redhat.driveSchoolAPIServer.infrastructure.ProfessorRepository;

@Stateless
@Path("/professores")
public class ProfessorResource {

	@EJB
	private ProfessorRepository professoresRepository;



	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTodosProfessores()
	{
		List<Professor> professores = professoresRepository.getTodosProfessores();
		GenericEntity<List<Professor>> professorWrapper = new GenericEntity<List<Professor>>(professores) {};
		return Response.ok(professorWrapper).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvaProfessor(final Professor professor) {

		Professor professorSalvo = professoresRepository.salvaProfessor(professor);
		return Response.ok(professorSalvo).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{cpfProfessor}")
	public Response getProfessor(@PathParam("cpfProfessor") int cpf) {
		Optional<Professor> professor = professoresRepository.getByCpf(cpf);

		if(professor.isPresent()) {
			return Response.ok(professor.get()).build();
		}
		return Response.noContent().build();
	}
}