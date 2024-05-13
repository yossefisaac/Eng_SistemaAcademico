package Model;

public class AlunoTurma {
    private Aluno aluno;
    private double nota;
    private int frequencia;

    public AlunoTurma(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        this.aluno = aluno;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
}
