package Facade;

import java.util.ArrayList;
import java.util.List;

import Model.Aluno;
import Model.AlunoTurma;
import Model.Professor;
import Model.Turma;
import Service.RelatorioService;
import Service.TurmaService;

public class ControleAcademicoFacade {
    private TurmaService turmaService;
    private RelatorioService relatorioService;

    // Construtor para inicializar os serviços
    public ControleAcademicoFacade() {
        this.turmaService = new TurmaService();
        this.relatorioService = new RelatorioService();
    }

    // Adiciona um aluno a uma turma
    public void adicionarAlunoEmTurma(Aluno aluno, Turma turma) {
        try {
            turmaService.adicionarAluno(turma, aluno);
        } catch (Exception e) {
            handleException("Erro ao adicionar aluno na turma", e);
        }
    }

    // Atribui uma nota a um aluno em uma turma
    public void atribuirNota(Aluno aluno, Turma turma, double nota) {
        try {
            turmaService.atribuirNota(aluno, turma, nota);
        } catch (Exception e) {
            handleException("Erro ao atribuir nota", e);
        }
    }

    // Atribui frequência a um aluno em uma turma
    public void atribuirFrequencia(Aluno aluno, Turma turma, int frequencia) {
        try {
            turmaService.atribuirFrequencia(aluno, turma, frequencia);
        } catch (Exception e) {
            handleException("Erro ao atribuir frequência", e);
        }
    }

    // Atribui um professor a uma turma
    public void atribuirProfessorParaTurma(Turma turma, Professor professor) {
        turma.setProfessor(professor);
    }

    // Busca uma turma pelo código
    public Turma buscarTurma(String codigo) {
        try {
            return turmaService.buscarTurma(codigo);
        } catch (Exception e) {
            handleException("Erro ao buscar turma", e);
            return null;
        }
    }

    // Busca uma disciplina pelo código da turma
    public String buscarDisciplina(String codigo) {
        try {
            return turmaService.buscarDisciplina(codigo);
        } catch (Exception e) {
            handleException("Erro ao buscar disciplina", e);
            return null;
        }
    }

    // Gera um relatório de notas para uma turma
    public void gerarRelatorioDeNotas(Turma turma) {
        try {
            relatorioService.gerarRelatorioDeNotas(turma);
        } catch (Exception e) {
            handleException("Erro ao gerar relatório de notas", e);
        }
    }

    // Gera um relatório de frequência para uma turma
    public void gerarRelatorioDeFrequencia(Turma turma) {
        try {
            relatorioService.gerarRelatorioDeFrequencia(turma);
        } catch (Exception e) {
            handleException("Erro ao gerar relatório de frequência", e);
        }
    }

    // Remove um aluno de uma turma
    public void removerAlunoDaTurma(Aluno aluno, Turma turma) {
        turma.removerAluno(aluno);
    }

    // Retorna uma lista de todos os alunos de todas as turmas
    public List<Aluno> getListaDeAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        for (Turma turma : turmaService.getListaDeTurmas()) {
            for (AlunoTurma alunoTurma : turma.getAlunos()) {
                alunos.add(alunoTurma.getAluno());
            }
        }
        return alunos;
    }

    // Gera um boletim para um aluno em uma turma
    public void gerarBoletimParaAluno(Aluno aluno, Turma turma) {
        try {
            relatorioService.gerarBoletimParaAluno(aluno, turma);
        } catch (Exception e) {
            handleException("Erro ao gerar boletim para aluno", e);
        }
    }

    // Método para lidar com exceções
    private void handleException(String message, Exception e) {
        // Imprime a mensagem de erro. Considere usar um sistema de logging em produção.
        System.err.println(message + ": " + e.getMessage());
    }
}
