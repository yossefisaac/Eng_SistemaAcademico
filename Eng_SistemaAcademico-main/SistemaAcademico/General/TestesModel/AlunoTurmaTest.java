package TestesModel;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Aluno;
import Model.AlunoTurma;

public class AlunoTurmaTest {

    @Test
    public void testCriarAlunoTurma() {
        // Testa a criação de um AlunoTurma com um aluno válido
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        AlunoTurma alunoTurma = new AlunoTurma(aluno);
        assertNotNull(alunoTurma);
        assertEquals(aluno, alunoTurma.getAluno());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarAlunoTurmaAlunoNulo() {
        // Testa a criação de um AlunoTurma com aluno nulo
        new AlunoTurma(null);
    }

    @Test
    public void testSetNota() {
        // Testa a definição da nota de um AlunoTurma
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        AlunoTurma alunoTurma = new AlunoTurma(aluno);
        alunoTurma.setNota(8.5);
        assertEquals(8.5, alunoTurma.getNota(), 0.001);
        assertEquals("Aprovado", alunoTurma.getSituacao());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNotaInvalida() {
        // Testa a definição de uma nota inválida para um AlunoTurma
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        AlunoTurma alunoTurma = new AlunoTurma(aluno);
        alunoTurma.setNota(11.0);
    }

    @Test
    public void testSetFrequencia() {
        // Testa a definição da frequência de um AlunoTurma
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        AlunoTurma alunoTurma = new AlunoTurma(aluno);
        alunoTurma.setFrequencia(80);
        assertEquals(80, alunoTurma.getFrequencia());
        assertEquals("Aprovado", alunoTurma.getSituacao());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFrequenciaInvalida() {
        // Testa a definição de uma frequência inválida para um AlunoTurma
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        AlunoTurma alunoTurma = new AlunoTurma(aluno);
        alunoTurma.setFrequencia(-10);
    }

    @Test
    public void testAtualizarSituacao() {
        // Testa a atualização da situação do aluno na turma
        Aluno aluno = new Aluno("Joao", "A001", "joao@example.com");
        AlunoTurma alunoTurma = new AlunoTurma(aluno);
        alunoTurma.setNota(8.5);
        alunoTurma.setFrequencia(90);
        assertEquals("Aprovado", alunoTurma.getSituacao());
    }
}
