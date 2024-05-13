package Model;

import java.util.regex.Pattern;

public class Aluno {
    private String nome;
    private String matricula;
    private String email;
    private String situacao;
    private double media;

    public Aluno(String nome, String matricula, String email) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do aluno não pode ser vazio.");
        }
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("Matrícula do aluno não pode ser vazia.");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("E-mail do aluno inválido.");
        }

        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
    }

    private boolean isValidEmail(String email) {
        // Simples validação de e-mail, pode ser melhorada conforme necessário
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(regex).matcher(email).matches();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }
}
