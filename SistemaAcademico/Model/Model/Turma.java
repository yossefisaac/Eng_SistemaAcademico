package Model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Disciplina disciplina;
    private Professor professor;
    private List<AlunoTurma> alunos;

    public Turma(String codigo, Disciplina disciplina) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("Código da turma não pode ser vazio.");
        }
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina da turma não pode ser nula.");
        }
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(new AlunoTurma(aluno));
    }

    public void atribuirNota(Aluno aluno, double nota) {
        for (AlunoTurma alunoTurma : alunos) {
            if (alunoTurma.getAluno().equals(aluno)) {
                alunoTurma.setNota(nota);
                break;
            }
        }
    }

    public void atribuirFrequencia(Aluno aluno, int frequencia) {
        for (AlunoTurma alunoTurma : alunos) {
            if (alunoTurma.getAluno().equals(aluno)) {
                alunoTurma.setFrequencia(frequencia);
                break;
            }
        }
    }

    // Getters e Setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<AlunoTurma> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoTurma> alunos) {
        this.alunos = alunos;
    }
}
