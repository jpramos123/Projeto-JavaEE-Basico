package driveSchoolAPI.com.redhat.driveSchoolAPIServer.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AutoEscola implements Serializable{

    List<Aluno> alunos = new ArrayList<>();
    List<Professor> professores = new ArrayList<>();


    private String nome;
    private int cnpj;
    
}