package TestesModel;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Disciplina;

public class DisciplinaTest {

    @Test
    public void testCriarDisciplina() {
        // Testa a criação de uma disciplina válida
        Disciplina disciplina = new Disciplina("MAT001", "Matemática", 60);
        assertNotNull(disciplina);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarDisciplinaCodigoNulo() {
        // Testa a criação de uma disciplina com código nulo
        new Disciplina(null, "Matemática", 60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarDisciplinaCodigoVazio() {
        // Testa a criação de uma disciplina com código vazio
        new Disciplina("", "Matemática", 60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarDisciplinaNomeNulo() {
        // Testa a criação de uma disciplina com nome nulo
        new Disciplina("MAT001", null, 60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarDisciplinaNomeVazio() {
        // Testa a criação de uma disciplina com nome vazio
        new Disciplina("MAT001", "", 60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarDisciplinaCargaHorariaNegativa() {
        // Testa a criação de uma disciplina com carga horária negativa
        new Disciplina("MAT001", "Matemática", -60);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarDisciplinaCargaHorariaZero() {
        // Testa a criação de uma disciplina com carga horária zero
        new Disciplina("MAT001", "Matemática", 0);
    }
}
