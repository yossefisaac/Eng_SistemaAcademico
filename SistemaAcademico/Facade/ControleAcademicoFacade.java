package Facade;

import Model.Aluno;
import Model.Professor;
import Model.Turma;
import Service.RelatorioService;
import Service.TurmaService;

public class ControleAcademicoFacade {
    private TurmaService turmaService;
    private RelatorioService relatorioService;

    public ControleAcademicoFacade() {
        this.turmaService = new TurmaService();
        this.relatorioService = new RelatorioService();
    }

    public void adicionarAlunoEmTurma(Aluno aluno, Turma turma) {
        turmaService.adicionarAluno(turma, aluno);
    }

    public void atribuirNota(Aluno aluno, Turma turma, double nota) {
        turmaService.atribuirNota(aluno, turma, nota);
    }

    public void atribuirFrequencia(Aluno aluno, Turma turma, int frequencia) {
        turmaService.atribuirFrequencia(aluno, turma, frequencia);
    }

    public void atribuirProfessorParaTurma(Professor professor, Turma turma) {
        turmaService.atribuirProfessor(turma, professor);
    }

    public void gerarRelatorioDeNotas(Turma turma) {
        relatorioService.gerarRelatorioDeNotas(turma);
    }

    public void gerarRelatorioDeFrequencia(Turma turma) {
        relatorioService.gerarRelatorioDeFrequencia(turma);
    }

    // Outros métodos da fachada, se necessário
}
