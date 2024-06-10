package Model;

public class ProfessorTurma {
    private Professor professor;
    private Turma turma;

    // Construtor para inicializar os atributos com validação
    public ProfessorTurma(Professor professor, Turma turma) {
        if (professor == null) {
            throw new IllegalArgumentException("Professor não pode ser nulo.");
        }
        if (turma == null) {
            throw new IllegalArgumentException("Turma não pode ser nula.");
        }
        this.professor = professor;
        this.turma = turma;
    }

    // Método para adicionar uma turma ao professor
    public void adicionarTurma(Turma turma) {
        if (turma == null) {
            throw new IllegalArgumentException("Turma não pode ser nula.");
        }
        this.turma = turma;
        System.out.println("Turma adicionada ao professor: " + professor.getNome());
    }

    // Método para remover a turma do professor
    public void removerTurma() {
        this.turma = null;
        System.out.println("Turma removida do professor: " + professor.getNome());
    }

    // Método para adicionar uma nota a um aluno na turma
    public void adicionarNotas(Aluno aluno, double nota) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        turma.atribuirNota(aluno, nota);
        System.out.println("Nota adicionada ao aluno: " + aluno.getNome());
    }

    // Método para remover um aluno da turma
    public void removerAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        turma.removerAluno(aluno);
        System.out.println("Aluno removido da turma: " + aluno.getNome());
    }

    // Método para modificar a nota de um aluno na turma
    public void modificarNotas(Aluno aluno, double novaNota) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        turma.atribuirNota(aluno, novaNota);
        System.out.println("Nota modificada do aluno: " + aluno.getNome());
    }

    // Getters e Setters com validação

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        if (professor == null) {
            throw new IllegalArgumentException("Professor não pode ser nulo.");
        }
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        if (turma == null) {
            throw new IllegalArgumentException("Turma não pode ser nula.");
        }
        this.turma = turma;
    }
}
