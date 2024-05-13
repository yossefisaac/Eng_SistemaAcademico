package Service;

import Model.Aluno;
import Model.Professor;
import Model.Turma;

public class TurmaService {
    public void adicionarAluno(Turma turma, Aluno aluno) {
        turma.adicionarAluno(aluno);
    }

    public void atribuirNota(Aluno aluno, Turma turma, double nota) {
        turma.atribuirNota(aluno, nota);
    }

    public void atribuirFrequencia(Aluno aluno, Turma turma, int frequencia) {
        turma.atribuirFrequencia(aluno, frequencia);
    }

    public void atribuirProfessor(Turma turma, Professor professor) {
        turma.setProfessor(professor);
    }

    // Outros métodos de serviço relacionados à turma
}
