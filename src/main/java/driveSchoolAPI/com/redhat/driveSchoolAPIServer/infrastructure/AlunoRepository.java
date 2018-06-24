package driveSchoolAPI.com.redhat.driveSchoolAPIServer.infrastructure;

import java.util.List;
import java.util.Optional;

import driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain.Aluno;

public interface AlunoRepository {
	
	Aluno salvaAluno (final Aluno aluno );
	Aluno deletaAluno (final Aluno aluno);
	
	List<Aluno> getTodosAlunos();
	
	Optional<Aluno> getByCpf(int cpf);
}
