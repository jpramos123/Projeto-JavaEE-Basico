package driveSchoolAPI.com.redhat.driveSchoolAPIServer.infrastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain.Aluno;


public class AlunoRepositoryBean implements AlunoRepository {

	@EJB
	private AlunoRepository alunosRepository;
	
	private final Map<Integer, Aluno> alunos = new HashMap<>();
	
	@Override
	public Aluno salvaAluno(Aluno aluno) {
		System.out.println(aluno);
		
		//adiciona aluno ao professor
		
		alunos.put(aluno.getCpf(), aluno);
		return aluno;
	}

	@Override
	public Aluno deletaAluno(Aluno aluno) {
		System.out.println(aluno);
		alunos.remove(aluno.getCpf());
		return aluno;
	}

	@Override
	public List<Aluno> getTodosAlunos() {
		return alunos.values().stream().collect(Collectors.toList());
	}

	@Override
	public Optional<Aluno> getByCpf(int cpf) {
		return Optional.ofNullable(alunos.get(cpf));
	}

	
}
