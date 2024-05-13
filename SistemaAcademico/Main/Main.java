package Main;

import Facade.ControleAcademicoFacade;
import Model.Aluno;
import Model.Disciplina;
import Model.Professor;
import Model.ProfessorTurma;
import Model.Turma;

public class Main {
    public static void main(String[] args) {
        // Exemplo de uso da fachada para interagir com o sistema
        ControleAcademicoFacade facade = new ControleAcademicoFacade();

        // Criação de objetos de modelo
        Aluno aluno1 = new Aluno("João", "A001", "joao@example.com");
        Aluno aluno2 = new Aluno("Maria", "A002", "maria@example.com");

        Disciplina matematica = new Disciplina("MAT001", "Matemática", 60);
        Disciplina fisica = new Disciplina("FIS001", "Física", 60);

        Professor professorMatematica = new Professor("1001", "Maria", "maria@example.com");
        Professor professorFisica = new Professor("1002", "Carlos", "carlos@example.com");

        Turma turmaMatematica = new Turma("TUR001", matematica);
        Turma turmaFisica = new Turma("TUR002", fisica);

        ProfessorTurma professorTurmaMatematica = new ProfessorTurma(professorMatematica, turmaMatematica);
        ProfessorTurma professorTurmaFisica = new ProfessorTurma(professorFisica, turmaFisica);

        // Adicionar alunos às turmas usando a fachada
        facade.adicionarAlunoEmTurma(aluno1, turmaMatematica);
        facade.adicionarAlunoEmTurma(aluno2, turmaFisica);

        // Atribuir nota e frequência para os alunos
        facade.atribuirNota(aluno1, turmaMatematica, 8.5);
        facade.atribuirFrequencia(aluno1, turmaMatematica, 90);

        facade.atribuirNota(aluno2, turmaFisica, 6.8);
        facade.atribuirFrequencia(aluno2, turmaFisica, 85);

        // Verificar média e atribuir situação aos alunos
        verificarSituacao(aluno1);
        verificarSituacao(aluno2);

        // Gerar relatórios de notas e frequências usando a fachada
        facade.gerarRelatorioDeNotas(turmaMatematica);
        facade.gerarRelatorioDeFrequencia(turmaMatematica);

        facade.gerarRelatorioDeNotas(turmaFisica);
        facade.gerarRelatorioDeFrequencia(turmaFisica);
    }

    private static void verificarSituacao(Aluno aluno) {
        double media = aluno.getMedia();
        if (media < 7.5) {
            aluno.setSituacao("Reprovado");
        } else {
            aluno.setSituacao("Aprovado");
        }
    }
}
