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
        System.out.println("Aluno " + aluno.getNome() + " adicionado à turma " + turma.getCodigo());
    }

    // Método para atribuir uma nota a um aluno em uma turma
    public void atribuirNota(Aluno aluno, Turma turma, double nota) {
        turma.atribuirNota(aluno, nota);
        System.out.println("Nota " + nota + " atribuída ao aluno " + aluno.getNome() + " na turma " + turma.getCodigo());
    }
    
    // Método para atribuir frequência a um aluno em uma turma
    public void atribuirFrequencia(Aluno aluno, Turma turma, int frequencia) {
        turma.atribuirFrequencia(aluno, frequencia);
        System.out.println("Frequência " + frequencia + "% atribuída ao aluno " + aluno.getNome() + " na turma " + turma.getCodigo());
    }

    // Método para atribuir um professor a uma turma
    public void atribuirProfessor(Turma turma, Professor professor) {
        turma.setProfessor(professor);
        System.out.println("Professor " + professor.getNome() + " atribuído à turma " + turma.getCodigo());
    }

    // Método para buscar uma turma pelo código
    public Turma buscarTurma(String codigo) {
        Turma turma = turmas.get(codigo);
        if (turma == null) {
            System.out.println("Turma com código " + codigo + " não encontrada.");
        }
        return turma;
    }

    // Método para buscar uma disciplina pelo código
    public String buscarDisciplina(String codigo) {
        String disciplina = disciplinas.get(codigo);
        if (disciplina == null) {
            System.out.println("Disciplina com código " + codigo + " não encontrada.");
        }
        return disciplina;
    }

    // Método para remover um aluno de uma turma
    public void removerAluno(Turma turma, Aluno aluno) {
        turma.removerAluno(aluno);
        System.out.println("Aluno " + aluno.getNome() + " removido da turma " + turma.getCodigo());
    }

    // Método para obter a lista de todas as turmas
    public Turma[] getListaDeTurmas() {
        return turmas.values().toArray(new Turma[0]);
    }

    // Método para adicionar uma nova turma
    public void adicionarTurma(Turma turma) {
        if (turma == null || turma.getCodigo().isEmpty()) {
            throw new IllegalArgumentException("Turma ou código da turma não pode ser nulo/vazio.");
        }
        if (turmas.containsKey(turma.getCodigo())) {
            throw new IllegalArgumentException("Já existe uma turma com o código " + turma.getCodigo());
        }
        turmas.put(turma.getCodigo(), turma);
        System.out.println("Turma " + turma.getCodigo() + " adicionada com sucesso.");
    }

    // Outros métodos de serviço relacionados à turma podem ser adicionados aqui
}
