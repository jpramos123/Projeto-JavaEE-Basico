

package driveSchoolAPI.com.redhat.driveSchoolAPIServer.infrastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain.Professor;

@Stateless
public class ProfessorRepositoryBean implements ProfessorRepository {
	
	@EJB
	private ProfessorRepository professoresRepository;
	
	private final Map<Integer, Professor> professores = new HashMap<>();

	@Override
	public Professor salvaProfessor(Professor professor) {
		System.out.println(professor);
		professores.put(professor.getCpf(), professor);
		return professor;
	}

	@Override
	public Professor deletaProfessor(Professor professor) {
		System.out.println(professor);
		professores.remove(professor.getCpf());
		return professor;
	}

	@Override
	public List<Professor> getTodosProfessores() {
		return professores.values().stream().collect(Collectors.toList());
	}

	@Override
	public Optional<Professor> getByCpf(int cpf) {
		return Optional.ofNullable(professores.get(cpf));
	}
	
	
}
