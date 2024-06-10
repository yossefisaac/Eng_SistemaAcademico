package Service;

import java.util.HashMap;
import java.util.Map;

import Model.Aluno;
import Model.Professor;
import Model.Turma;

public class TurmaService {
    private Map<String, Turma> turmas;
    private Map<String, String> disciplinas;

    // Construtor para inicializar os mapas de turmas e disciplinas
    public TurmaService() {
        this.turmas = new HashMap<>();
        this.disciplinas = new HashMap<>();
    }

    // Método para adicionar um aluno a uma turma
    public void adicionarAluno(Turma turma, Aluno aluno) {
        turma.adicionarAluno(aluno);
    }

    // Método para atribuir uma nota a um aluno em uma turma
    public void atribuirNota(Aluno aluno, Turma turma, double nota) {
        turma.atribuirNota(aluno, nota);
    }    
    
    // Método para atribuir frequência a um aluno em uma turma
    public void atribuirFrequencia(Aluno aluno, Turma turma, int frequencia) {
        turma.atribuirFrequencia(aluno, frequencia);
    }

    // Método para atribuir um professor a uma turma
    public void atribuirProfessor(Turma turma, Professor professor) {
        turma.setProfessor(professor);
    }

    // Método para buscar uma turma pelo código
    public Turma buscarTurma(String codigo) {
        return turmas.get(codigo);
    }

    // Método para buscar uma disciplina pelo código
    public String buscarDisciplina(String codigo) {
        return disciplinas.get(codigo);
    }

    // Método para remover um aluno de uma turma
    public void removerAluno(Turma turma, Aluno aluno) {
        turma.removerAluno(aluno);
    }

    // Método para obter a lista de todas as turmas
    public Turma[] getListaDeTurmas() {
        return turmas.values().toArray(new Turma[0]);
    }

    public void adicionarTurma(Turma turma) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'adicionarTurma'");
    }
    
    // Outros métodos de serviço relacionados à turma podem ser adicionados aqui
}
