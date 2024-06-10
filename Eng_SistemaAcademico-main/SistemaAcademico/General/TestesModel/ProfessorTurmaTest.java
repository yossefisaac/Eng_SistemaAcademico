package TestesModel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Model.Aluno;
import Model.AlunoTurma;
import Model.Disciplina;
import Model.Professor;
import Model.ProfessorTurma;
import Model.Turma;

public class ProfessorTurmaTest {

    private Professor professor;
    private Turma turma;
    private Aluno aluno;

    @Before
    public void setUp() {
        // Configuração inicial para os testes
        professor = new Professor("1001", "Marlene", "marlene@example.com");
        Disciplina disciplina = new Disciplina("MAT001", "Matemática", 60);
        turma = new Turma("TUR001", disciplina);
        aluno = new Aluno("Joao", "A001", "joao@example.com");
    }

    @Test
    public void testCriarProfessorTurma() {
        // Testa a criação de uma instância válida de ProfessorTurma
        ProfessorTurma professorTurma = new ProfessorTurma(professor, turma);
        assertNotNull(professorTurma);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorTurmaProfessorNulo() {
        // Testa a criação de ProfessorTurma com professor nulo
        new ProfessorTurma(null, turma);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorTurmaTurmaNula() {
        // Testa a criação de ProfessorTurma com turma nula
        new ProfessorTurma(professor, null);
    }

    @Test
    public void testAdicionarTurma() {
        // Testa a adição de turma a um professor
        ProfessorTurma professorTurma = new ProfessorTurma(professor, turma);
        Turma novaTurma = new Turma("TUR002", new Disciplina("FIS002", "Física", 60));
        professorTurma.adicionarTurma(novaTurma);
        assertEquals(novaTurma, professorTurma.getTurma());
    }

    @Test
    public void testRemoverTurma() {
        // Testa a remoção de turma de um professor
        ProfessorTurma professorTurma = new ProfessorTurma(professor, turma);
        professorTurma.removerTurma();
        assertNull(professorTurma.getTurma());
    }

    @Test
    public void testAdicionarNotas() {
        // Testa a adição de notas a um aluno na turma
        ProfessorTurma professorTurma = new ProfessorTurma(professor, turma);
        double nota = 8.5;
        professorTurma.adicionarNotas(aluno, nota);
        assertEquals(nota, aluno.getNota(), 0.01);
    }

    @Test
    public void testRemoverAluno() {
        // Testa a remoção de um aluno da turma
        turma.adicionarAluno(aluno);
        ProfessorTurma professorTurma = new ProfessorTurma(professor, turma);
        professorTurma.removerAluno(aluno);
        assertFalse(turma.getAlunos().contains(new AlunoTurma(aluno)));
    }

    @Test
    public void testModificarNotas() {
        // Testa a modificação da nota de um aluno na turma
        turma.adicionarAluno(aluno);
        ProfessorTurma professorTurma = new ProfessorTurma(professor, turma);
        double novaNota = 9.0;
        professorTurma.modificarNotas(aluno, novaNota);
        assertEquals(novaNota, aluno.getNota(), 0.01);
    }
}

