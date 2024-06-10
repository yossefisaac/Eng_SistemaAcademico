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

    public ControleAcademicoFacade() {
        this.turmaService = new TurmaService();
        this.relatorioService = new RelatorioService();
    }

    public void adicionarAlunoEmTurma(Aluno aluno, Turma turma) {
        try {
            turmaService.adicionarAluno(turma, aluno);
        } catch (Exception e) {
            System.err.println("Erro ao adicionar aluno na turma: " + e.getMessage());
        }
    }

    public void atribuirNota(Aluno aluno, Turma turma, double nota) {
        try {
            turmaService.atribuirNota(aluno, turma, nota);
        } catch (Exception e) {
            System.err.println("Erro ao atribuir nota: " + e.getMessage());
        }
    }

    public void atribuirFrequencia(Aluno aluno, Turma turma, int frequencia) {
        try {
            turmaService.atribuirFrequencia(aluno, turma, frequencia);
        } catch (Exception e) {
            System.err.println("Erro ao atribuir frequência: " + e.getMessage());
        }
    }

    public void atribuirProfessorParaTurma(Turma turma, Professor professor) {
        turma.setProfessor(professor);
    }

    public Turma buscarTurma(String codigo) {
        try {
            return turmaService.buscarTurma(codigo);
        } catch (Exception e) {
            System.err.println("Erro ao buscar turma: " + e.getMessage());
            return null;
        }
    }

    public String buscarDisciplina(String codigo) {
        try {
            return turmaService.buscarDisciplina(codigo);
        } catch (Exception e) {
            System.err.println("Erro ao buscar disciplina: " + e.getMessage());
            return null;
        }
    }

    public void gerarRelatorioDeNotas(Turma turma) {
        try {
            relatorioService.gerarRelatorioDeNotas(turma);
        } catch (Exception e) {
            System.err.println("Erro ao gerar relatório de notas: " + e.getMessage());
        }
    }

    public void gerarRelatorioDeFrequencia(Turma turma) {
        try {
            relatorioService.gerarRelatorioDeFrequencia(turma);
        } catch (Exception e) {
            System.err.println("Erro ao gerar relatório de frequência: " + e.getMessage());
        }
    }


    public void removerAlunoDaTurma(Aluno aluno, Turma turma) {
        turma.removerAluno(aluno);
    }

    public List<Aluno> getListaDeAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        for (Turma turma : turmaService.getListaDeTurmas()) {
            for (AlunoTurma alunoTurma : turma.getAlunos()) {
                alunos.add(alunoTurma.getAluno());
            }
        }
        return alunos;
    } 
    public void gerarBoletimParaAluno(Aluno aluno, Turma turma) {
        relatorioService.gerarBoletimParaAluno(aluno, turma);
    }
}
