package TestesModel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Model.Aluno;
import Model.AlunoTurma;
import Model.Disciplina;
import Model.Turma;

public class TurmaTest {

    private Turma turma;
    private Aluno aluno1;
    private Aluno aluno2;

    @Before
    public void setUp() {
        // Configuração inicial para os testes
        Disciplina disciplina = new Disciplina("MAT001", "Matemática", 60);
        turma = new Turma("TUR001", disciplina);
        aluno1 = new Aluno("Joao", "A001", "joao@example.com");
        aluno2 = new Aluno("Maria", "A002", "maria@example.com");
    }

    @Test
    public void testCriarTurma() {
        // Testa a criação de uma instância válida de Turma
        assertNotNull(turma);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarTurmaCodigoNulo() {
        // Testa a criação de Turma com código nulo
        new Turma(null, new Disciplina("FIS001", "Física", 60));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarTurmaCodigoVazio() {
        // Testa a criação de Turma com código vazio
        new Turma("", new Disciplina("FIS001", "Física", 60));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarTurmaDisciplinaNula() {
        // Testa a criação de Turma com disciplina nula
        new Turma("TUR002", null);
    }

    @Test
    public void testAdicionarAluno() {
        // Testa a adição de alunos à turma
        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);
        assertEquals(2, turma.getAlunos().size());
    }

    @Test
    public void testRemoverAluno() {
        // Testa a remoção de aluno da turma
        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);
        turma.removerAluno(aluno1);
        assertFalse(turma.getAlunos().contains(new AlunoTurma(aluno1)));
    }

    @Test
    public void testAtribuirNota() {
        // Testa a atribuição de nota a um aluno na turma
        turma.adicionarAluno(aluno1);
        double nota = 8.5;
        turma.atribuirNota(aluno1, nota);
        assertEquals(nota, turma.getAlunoTurma(aluno1).getNota(), 0.01);
    }

    @Test
    public void testAtribuirFrequencia() {
        // Testa a atribuição de frequência a um aluno na turma
        turma.adicionarAluno(aluno1);
        int frequencia = 80;
        turma.atribuirFrequencia(aluno1, frequencia);
        assertEquals(frequencia, turma.getAlunoTurma(aluno1).getFrequencia());
    }

    @Test
    public void testMostrarTurmaAlunos() {
        // Testa a exibição da lista de alunos da turma
        turma.adicionarAluno(aluno1);
        turma.adicionarAluno(aluno2);
        turma.mostrarTurmaAlunos();
        // Simplesmente verifica se o método não causa exceções
    }

    @Test
    public void testMostrarTurmas() {
        // Testa a exibição da lista de turmas
        List<Turma> turmas = new ArrayList<>();
        turmas.add(turma);
        Turma.mostrarTurmas(turmas);
        // Simplesmente verifica se o método não causa exceções
    }

    @Test
    public void testGetNotaDoAluno() {
        // Testa a obtenção da nota de um aluno na turma
        turma.adicionarAluno(aluno1);
        double nota = 7.0;
        turma.atribuirNota(aluno1, nota);
        assertEquals(String.valueOf(nota), turma.getNotaDoAluno(aluno1));
    }

    @Test
    public void testGetFrequenciaDoAluno() {
        // Testa a obtenção da frequência de um aluno na turma
        turma.adicionarAluno(aluno1);
        int frequencia = 75;
        turma.atribuirFrequencia(aluno1, frequencia);
        assertEquals(String.valueOf(frequencia), turma.getFrequenciaDoAluno(aluno1));
    }

    // Métodos getSituacao() e contemAluno() não testados pois lançam UnsupportedOperationException
}

