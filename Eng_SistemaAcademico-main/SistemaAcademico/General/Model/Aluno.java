package Model;

import java.util.regex.Pattern;

public class Aluno {
    private String nome;
    private String matricula;
    private String email;
    private String situacao;
    private double media;
    private double nota;
    private int frequencia;
    private Turma turma; // Referência à turma

    // Construtor principal
    public Aluno(String nome, String matricula, String email) {
        setNome(nome);
        setMatricula(matricula);
        setEmail(email);
        verificarSituacao();
    }

    // Construtor vazio (se necessário)
    public Aluno(String string) {
        // Implementação necessária se for utilizado em algum contexto
    }

    // Verifica e define a situação do aluno (aprovado ou reprovado)
    private void verificarSituacao() {
        if (this.nota >= 7.0 && this.frequencia >= 70) {
            this.situacao = "Aprovado";
        } else {
            this.situacao = "Reprovado";
        }
    }

    // Validação de email
    private static boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    // Getters e setters com validações
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do aluno não pode ser vazio.");
        }
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("Matrícula do aluno não pode ser vazia.");
        }
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("E-mail do aluno inválido.");
        }
        this.email = email;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
        verificarSituacao();
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
        verificarSituacao();
    }

    public double getMedia() {
        return media;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    // Calcula a média das notas do aluno na turma
    public double calcularMedia() {
        if (turma == null) {
            System.err.println("Erro: Aluno não está matriculado em nenhuma turma.");
            return 0.0;
        }

        double somaDasNotas = turma.getAlunos().stream()
                                    .mapToDouble(AlunoTurma::getNota)
                                    .sum();

        int quantidadeDeNotas = turma.getAlunos().size();

        if (quantidadeDeNotas == 0) {
            System.err.println("Erro: Nenhuma nota encontrada para o aluno.");
            return 0.0;
        }

        return somaDasNotas / quantidadeDeNotas;
    }

    // Calcula a frequência do aluno na turma
    public int calcularFrequencia() {
        if (turma == null) {
            System.err.println("Erro: Aluno não está matriculado em nenhuma turma.");
            return 0;
        }

        int somaDasFrequencias = turma.getAlunos().stream()
                                      .mapToInt(AlunoTurma::getFrequencia)
                                      .sum();

        int quantidadeDeFrequencias = turma.getAlunos().size();

        if (quantidadeDeFrequencias == 0) {
            System.err.println("Erro: Nenhuma frequência encontrada para o aluno.");
            return 0;
        }

        return somaDasFrequencias / quantidadeDeFrequencias;
    }

    public Aluno getAlunoTurma(Turma turma) {
        // Implementação necessária se for utilizado em algum contexto
        throw new UnsupportedOperationException("Unimplemented method 'getAlunoTurma'");
    }
}
