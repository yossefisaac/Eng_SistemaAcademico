package Main;

import Facade.ControleAcademicoFacade;
import Model.Aluno;
import Model.Disciplina;
import Model.Professor;
import Model.Turma;

public class Main {
    public static void main(String[] args) {
        // Exemplo de uso da fachada para interagir com o sistema
        ControleAcademicoFacade controleAcademico = new ControleAcademicoFacade(); // Criação da instância da fachada

        // Criação de objetos de modelo
        Aluno aluno1 = new Aluno("Joao", "A001", "joao@example.com");
        Aluno aluno2 = new Aluno("Maria", "A002", "maria@example.com");
        Aluno aluno3 = new Aluno("Pedro", "A003", "pedro@example.com");
        Aluno aluno4 = new Aluno("Ana", "A004", "ana@example.com");
        Aluno aluno5 = new Aluno("Lucas", "A005", "lucas@example.com");
        Aluno aluno6 = new Aluno("Mariana", "A006", "mariana@example.com");
        Aluno aluno7 = new Aluno("Carlos", "A007", "carlos@example.com");
        Aluno aluno8 = new Aluno("Laura", "A008", "laura@example.com");
        Aluno aluno9 = new Aluno("Roberto", "A009", "roberto@example.com");
        Aluno aluno10 = new Aluno("Sofia", "A010", "sofia@example.com");

        Disciplina matematica = new Disciplina("MAT001", "Matematica", 60);
        Disciplina fisica = new Disciplina("FIS001", "Física", 60);

        Professor professorMatematica = new Professor("1001", "Marlene", "marlene@example.com");
        Professor professorFisica = new Professor("1002", "Carlos", "carlos@example.com");

        Turma turmaMatematica = new Turma("TUR001", matematica);
        Turma turmaFisica = new Turma("TUR002", fisica);

        // Adicionar alunos às turmas usando a fachada
        controleAcademico.adicionarAlunoEmTurma(aluno1, turmaMatematica);
        controleAcademico.adicionarAlunoEmTurma(aluno2, turmaFisica);
        controleAcademico.adicionarAlunoEmTurma(aluno3, turmaMatematica);
        controleAcademico.adicionarAlunoEmTurma(aluno4, turmaFisica);
        controleAcademico.adicionarAlunoEmTurma(aluno5, turmaMatematica);
        controleAcademico.adicionarAlunoEmTurma(aluno6, turmaFisica);
        controleAcademico.adicionarAlunoEmTurma(aluno7, turmaMatematica);
        controleAcademico.adicionarAlunoEmTurma(aluno8, turmaFisica);
        controleAcademico.adicionarAlunoEmTurma(aluno9, turmaMatematica);
        controleAcademico.adicionarAlunoEmTurma(aluno10, turmaFisica);

        // Atribuir nota e frequência para os alunos
        controleAcademico.atribuirNota(aluno1, turmaMatematica, 8.5);
        controleAcademico.atribuirFrequencia(aluno1, turmaMatematica, 90);

        controleAcademico.atribuirNota(aluno2, turmaFisica, 6.8);
        controleAcademico.atribuirFrequencia(aluno2, turmaFisica, 75);

        controleAcademico.atribuirNota(aluno3, turmaMatematica, 7.0);
        controleAcademico.atribuirFrequencia(aluno3, turmaMatematica, 85);

        controleAcademico.atribuirNota(aluno4, turmaFisica, 5.0);
        controleAcademico.atribuirFrequencia(aluno4, turmaFisica, 60);

        controleAcademico.atribuirNota(aluno5, turmaMatematica, 9.0);
        controleAcademico.atribuirFrequencia(aluno5, turmaMatematica, 95);

        controleAcademico.atribuirNota(aluno6, turmaFisica, 3.5);
        controleAcademico.atribuirFrequencia(aluno6, turmaFisica, 80);

        controleAcademico.atribuirNota(aluno7, turmaMatematica, 6.0);
        controleAcademico.atribuirFrequencia(aluno7, turmaMatematica, 75);

        controleAcademico.atribuirNota(aluno8, turmaFisica, 8.0);
        controleAcademico.atribuirFrequencia(aluno8, turmaFisica, 70);

        controleAcademico.atribuirNota(aluno9, turmaMatematica, 4.0);
        controleAcademico.atribuirFrequencia(aluno9, turmaMatematica, 50);

        controleAcademico.atribuirNota(aluno10, turmaFisica, 7.5);
        controleAcademico.atribuirFrequencia(aluno10, turmaFisica, 90);

        // Atribuir professor a turma
        controleAcademico.atribuirProfessorParaTurma(turmaMatematica, professorMatematica);
        controleAcademico.atribuirProfessorParaTurma(turmaFisica, professorFisica);

        // Remover aluno
        controleAcademico.removerAlunoDaTurma(aluno2, turmaFisica);

        // Mostrar lista de alunos em uma turma
        System.out.println();
        System.out.println("****************************************************************************************************************************");
        System.out.println();
        System.out.println("Alunos na turma de Matemática:");
        turmaMatematica.mostrarTurmaAlunos();

        System.out.println("\nAlunos na turma de Física:");
        turmaFisica.mostrarTurmaAlunos();

        // Gerar relatórios de notas e frequências usando a fachada
        System.out.println("\nRelatório de Notas da Turma de Matemática:");
        controleAcademico.gerarRelatorioDeNotas(turmaMatematica);
        System.out.println("\nRelatório de Frequência da Turma de Matemática:");
        controleAcademico.gerarRelatorioDeFrequencia(turmaMatematica);

        System.out.println("\nRelatório de Notas da Turma de Física:");
        controleAcademico.gerarRelatorioDeNotas(turmaFisica);
        System.out.println("\nRelatório de Frequência da Turma de Física:");
        controleAcademico.gerarRelatorioDeFrequencia(turmaFisica);

        // Gerar boletim para um aluno específico usando a fachada
        System.out.println("\nBoletim do Aluno Joao da Turma de Matemática:");
        controleAcademico.gerarBoletimParaAluno(aluno1, turmaMatematica);
    }
}