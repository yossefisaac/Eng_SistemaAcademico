package Service;

import Model.Aluno;
import Model.AlunoTurma;
import Model.Turma;

public class RelatorioService {
    
    // Gera um relatório de notas para a turma
    public void gerarRelatorioDeNotas(Turma turma) {
        System.out.println();
        System.out.println("Relatório de Notas da Turma: " + turma.getCodigo());
        System.out.println("Professor: " + turma.getProfessor().getNome());
        System.out.println("----------------------------------------------------");
        for (AlunoTurma alunoTurma : turma.getAlunos()) {
            System.out.println("Aluno: " + alunoTurma.getAluno().getNome() + 
                               ", Nota: " + alunoTurma.getNota() + 
                               ", Situação: " + alunoTurma.getSituacao());
        }
        System.out.println();
    }

    // Gera um relatório de frequência para a turma
    public void gerarRelatorioDeFrequencia(Turma turma) {
        System.out.println("Relatório de Frequência da Turma: " + turma.getCodigo());
        System.out.println("----------------------------------------------------");
        for (AlunoTurma alunoTurma : turma.getAlunos()) {
            System.out.println("Aluno: " + alunoTurma.getAluno().getNome() + 
                               ", Frequência: " + alunoTurma.getFrequencia() + "%");
        }
        System.out.println();
        System.out.println("****************************************************************************************************************************");
        System.out.println();
    }

    // Gera um boletim para um aluno específico em uma turma
    public void gerarBoletimParaAluno(Aluno aluno, Turma turma) {
        AlunoTurma alunoTurma = turma.getAlunoTurma(aluno);
        if (alunoTurma != null) {
            System.out.println("Boletim do Aluno: " + aluno.getNome());
            System.out.println("Turma: " + turma.getCodigo());
            System.out.println("Disciplina: " + turma.getDisciplina().getNome());
            System.out.println("Nota: " + alunoTurma.getNota());
            System.out.println("Frequência: " + alunoTurma.getFrequencia() + "%");
            System.out.println("Situação: " + alunoTurma.getSituacao());
        } else {
            System.out.println("Aluno não encontrado na turma.");
        }
    }
}
