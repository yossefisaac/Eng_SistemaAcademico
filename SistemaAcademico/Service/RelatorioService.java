package Service;

import Model.AlunoTurma;
import Model.Turma;

public class RelatorioService {
    public void gerarRelatorioDeNotas(Turma turma) {
        System.out.println("Relatório de Notas da Turma: " + turma.getCodigo());
        for (AlunoTurma alunoTurma : turma.getAlunos()) {
            String situacao = alunoTurma.getAluno().getSituacao();
            System.out.println("Aluno: " + alunoTurma.getAluno().getNome() + ", Nota: " + alunoTurma.getNota() + ", Situação: " + situacao);
        }
    }

    public void gerarRelatorioDeFrequencia(Turma turma) {
        System.out.println("Relatório de Frequência da Turma: " + turma.getCodigo());
        for (AlunoTurma alunoTurma : turma.getAlunos()) {
            String situacao = alunoTurma.getAluno().getSituacao();
            System.out.println("Aluno: " + alunoTurma.getAluno().getNome() + ", Frequência: " + alunoTurma.getFrequencia() + "%, Situação: " + situacao);
        }
    }

    // Outros métodos para gerar relatórios
}
