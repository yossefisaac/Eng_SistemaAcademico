package TestesModel;

import static org.junit.Assert.*;

import org.junit.*;

import Model.Aluno;
import Model.Disciplina;
import Model.Turma;

public class AlunoTest {

    @Test
    public void testCriarAluno() {
        // Testa a criação de um aluno com informações válidas
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        assertNotNull(aluno);
        assertEquals("Joao", aluno.getNome());
        assertEquals("A001", aluno.getMatricula());
        assertEquals("joao@example.com", aluno.getEmail());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarAlunoNomeNulo() {
        // Testa a criação de um aluno com nome nulo
        new Aluno(null, "A001", "joao@example.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarAlunoMatriculaNula() {
        // Testa a criação de um aluno com matrícula nula
        new Aluno("Joao", null, "joao@example.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarAlunoEmailNulo() {
        // Testa a criação de um aluno com e-mail nulo
        new Aluno("Joao", "A001", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarAlunoEmailInvalido() {
        // Testa a criação de um aluno com e-mail inválido
        new Aluno("Joao", "A001", "joaoexample.com");
    }

    @Test
    public void testSetNota() {
        // Testa a definição da nota de um aluno
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        aluno.setNota(8.5);
        assertEquals(8.5, aluno.getNota(), 0.001);
        assertEquals("Aprovado", aluno.getSituacao());
    }

    @Test
    public void testSetFrequencia() {
        // Testa a definição da frequência de um aluno
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        aluno.setFrequencia(80);
        assertEquals(80, aluno.getFrequencia());
        assertEquals("Aprovado", aluno.getSituacao());
    }

    @Test
    public void testSetTurma() {
        // Testa a definição da turma de um aluno
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        Turma turma = new Turma("T001", new Disciplina("D001", "Matemática", 60));
        aluno.setTurma(turma);
        assertEquals(turma, aluno.getTurma());
    }

    @Test
    public void testCalcularMedia() {
        // Testa o cálculo da média das notas do aluno
        Turma turma = new Turma("T001", new Disciplina("D001", "Matemática", 60));
        Aluno aluno1 = new Aluno("Joao", "A001", "joao@example.com");
        Aluno aluno2 = new Aluno("Maria", "A002", "maria@example.com");
        aluno1.setTurma(turma);
        aluno2.setTurma(turma);
        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);
        aluno1.setNota(8.5);
        aluno2.setNota(7.0);
        assertEquals(7.75, aluno1.calcularMedia(), 0.001);
    }

    @Test
    public void testCalcularFrequencia() {
        // Testa o cálculo da média da frequência do aluno
        Turma turma = new Turma("T001", new Disciplina("D001", "Matemática", 60));
        Aluno aluno1 = new Aluno("Joao", "A001", "joao@example.com");
        Aluno aluno2 = new Aluno("Maria", "A002", "maria@example.com");
        aluno1.setTurma(turma);
        aluno2.setTurma(turma);
        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);
        aluno1.setFrequencia(90);
        aluno2.setFrequencia(85);
        assertEquals(87, aluno1.calcularFrequencia());
    }
}

