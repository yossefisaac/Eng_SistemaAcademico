package TestesModel;

import static org.junit.Assert.*;

import org.junit.Test;

import Model.Professor;

public class ProfessorTest {

    @Test
    public void testCriarProfessor() {
        // Testa a criação de um professor válido
        Professor professor = new Professor("1001", "Marlene", "marlene@example.com");
        assertNotNull(professor);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorIdNulo() {
        // Testa a criação de um professor com ID nulo
        new Professor(null, "Marlene", "marlene@example.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorIdVazio() {
        // Testa a criação de um professor com ID vazio
        new Professor("", "Marlene", "marlene@example.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorNomeNulo() {
        // Testa a criação de um professor com nome nulo
        new Professor("1001", null, "marlene@example.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorNomeVazio() {
        // Testa a criação de um professor com nome vazio
        new Professor("1001", "", "marlene@example.com");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorEmailNulo() {
        // Testa a criação de um professor com e-mail nulo
        new Professor("1001", "Marlene", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorEmailVazio() {
        // Testa a criação de um professor com e-mail vazio
        new Professor("1001", "Marlene", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCriarProfessorEmailInvalido() {
        // Testa a criação de um professor com e-mail inválido
        new Professor("1001", "Marlene", "email_invalido");
    }
}
