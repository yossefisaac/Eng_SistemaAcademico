package Model;

import java.util.List;

public class AlunoTurma {
    private Aluno aluno;
    private double nota;
    private int frequencia;
    private String situacao;

    // Construtor para inicializar AlunoTurma com um Aluno
    public AlunoTurma(Aluno aluno) {
        setAluno(aluno);
        this.situacao = "Indefinido"; // Situação inicial
    }

    // Método estático para buscar uma turma pelo código na lista de turmas
    public static Turma buscarTurma(List<Turma> listaTurmas, String codigo) {
        for (Turma turma : listaTurmas) {
            if (turma.getCodigo().equals(codigo)) {
                System.out.println("Turma encontrada com código: " + turma.getCodigo());
                return turma;
            }
        }
        System.out.println("Turma não encontrada com código: " + codigo);
        return null;
    }

    // Getters e setters com validações
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        this.aluno = aluno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10.");
        }
        this.nota = nota;
        atualizarSituacao();
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        if (frequencia < 0 || frequencia > 100) {
            throw new IllegalArgumentException("Frequência deve estar entre 0 e 100.");
        }
        this.frequencia = frequencia;
        atualizarSituacao();
    }

    public String getSituacao() {
        return situacao;
    }

    // Método privado para atualizar a situação do aluno na turma
    private void atualizarSituacao() {
        if (nota >= 7.0 && frequencia >= 70) {
            this.situacao = "Aprovado";
        } else {
            this.situacao = "Reprovado";
        }
    }
}
