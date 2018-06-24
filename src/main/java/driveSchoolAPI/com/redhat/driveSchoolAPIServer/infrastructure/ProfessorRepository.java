package driveSchoolAPI.com.redhat.driveSchoolAPIServer.infrastructure;

import java.util.List;
import java.util.Optional;

import driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain.Professor;

public interface ProfessorRepository {

	Professor salvaProfessor(final Professor professor);
	
	Professor deletaProfessor(final Professor professor);
	
	List<Professor> getTodosProfessores();
	
	Optional<Professor> getByCpf(int cpf);
	
}
