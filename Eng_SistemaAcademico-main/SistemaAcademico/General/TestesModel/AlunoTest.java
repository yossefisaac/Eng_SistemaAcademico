package TestesModel;

import static org.junit.Assert.*;

import org.junit.Test;

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
        // Testa a criação de um aluno com e-mail nulo, espera-se erro.
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
        aluno.setNota(5.5);
        assertEquals(5.5, aluno.getNota(), 0.001);
        assertEquals("Reprovado", aluno.getSituacao());
    }

    @Test
    public void testSetFrequencia() {
        // Testa a definição da frequência de um aluno
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        aluno.setFrequencia(50);
        assertEquals(50, aluno.getFrequencia());
        assertEquals("Reprovado", aluno.getSituacao());
    }

    @Test
    public void testSetTurma() {
        // Testa a definição da turma de um aluno
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        Turma turma = new Turma("T001", new Disciplina("D001", "Matemática", 60));
        aluno.setTurma(turma);
        assertEquals(turma, aluno.getTurma());
    }
}
