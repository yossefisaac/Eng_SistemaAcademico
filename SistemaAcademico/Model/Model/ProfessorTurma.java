package Model;

public class ProfessorTurma {
    private Professor professor;
    private Turma turma;

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

    // Getters e Setters

    /**
     * @return Professor return the professor
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * @param professor the professor to set
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    /**
     * @return Turma return the turma
     */
    public Turma getTurma() {
        return turma;
    }

    /**
     * @param turma the turma to set
     */
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}