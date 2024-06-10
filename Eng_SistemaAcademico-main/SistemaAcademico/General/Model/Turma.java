package Model;

import java.util.ArrayList;
import java.util.Iterator;
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

    // Função para mostrar a lista de alunos
    public void mostrarTurmaAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados na turma.");
            return;
        }

        System.out.println("Lista de Alunos:");
        for (AlunoTurma alunoTurma : alunos) {
            Aluno aluno = alunoTurma.getAluno();
            System.out.println("- " + aluno.getNome());
        }
    }

    public static void mostrarTurmas(List<Turma> listaTurmas) {
        if (listaTurmas.isEmpty()) {
            System.out.println("Não há turmas cadastradas.");
            return;
        }

        System.out.println("Lista de Turmas:");
        for (Turma turma : listaTurmas) {
            System.out.println("- Código: " + turma.getCodigo() + ", Disciplina: " + turma.getDisciplina().getNome());
        }
    }

    public void removerAluno(Aluno aluno) {
        Iterator<AlunoTurma> iterator = alunos.iterator();
        while (iterator.hasNext()) {
            AlunoTurma alunoTurma = iterator.next();
            if (alunoTurma.getAluno().equals(aluno)) {
                iterator.remove();
                System.out.println("Aluno " + aluno.getNome() + " removido da turma.");
                return;
            }
        }
        System.out.println("Aluno " + aluno.getNome() + " não encontrado na turma.");
    }

    public void modifyAluno(Aluno aluno, double novaNota, int novaFrequencia) {
        for (AlunoTurma alunoTurma : alunos) {
            if (alunoTurma.getAluno().equals(aluno)) {
                alunoTurma.setNota(novaNota);
                alunoTurma.setFrequencia(novaFrequencia);
                System.out.println("Dados do aluno " + aluno.getNome() + " atualizados para nota: " + novaNota + " e frequência: " + novaFrequencia + "%");
                return;
            }
        }
        System.out.println("Aluno " + aluno.getNome() + " não encontrado na turma.");
    }

    public void atribuirNota(Aluno aluno, double nota) {
        for (AlunoTurma alunoTurma : alunos) {
            if (alunoTurma.getAluno().equals(aluno)) {
                alunoTurma.setNota(nota);
                return;
            }
        }
        System.out.println("Aluno " + aluno.getNome() + " não encontrado na turma.");
    }

    public void atribuirFrequencia(Aluno aluno, int frequencia) {
        for (AlunoTurma alunoTurma : alunos) {
            if (alunoTurma.getAluno().equals(aluno)) {
                alunoTurma.setFrequencia(frequencia);
                return;
            }
        }
        System.out.println("Aluno " + aluno.getNome() + " não encontrado na turma.");
    }

    public AlunoTurma getAlunoTurma(Aluno aluno) {
        for (AlunoTurma alunoTurma : alunos) {
            if (alunoTurma.getAluno().equals(aluno)) {
                return alunoTurma;
            }
        }
        return null;
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

    public String getNotaDoAluno(Aluno aluno) {
        for (AlunoTurma alunoTurma : alunos) {
            if (alunoTurma.getAluno().equals(aluno)) {
                return String.valueOf(alunoTurma.getNota());
            }
        }
        return "Nota não encontrada para o aluno " + aluno.getNome();
    }

    public String getFrequenciaDoAluno(Aluno aluno) {
        for (AlunoTurma alunoTurma : alunos) {
            if (alunoTurma.getAluno().equals(aluno)) {
                return String.valueOf(alunoTurma.getFrequencia());
            }
        }
        return "Frequência não encontrada para o aluno " + aluno.getNome();
    }

    public String getSituacao(Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSituacao'");
    }

    public boolean contemAluno(Aluno aluno) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contemAluno'");
    }
}
