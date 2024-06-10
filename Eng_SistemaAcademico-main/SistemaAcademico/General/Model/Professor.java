package Model;

import java.util.regex.Pattern;

public class Professor {
    private String id;
    private String nome;
    private String email;

    // Construtor para inicializar os atributos com validação
    public Professor(String id, String nome, String email) {
        setId(id);
        setNome(nome);
        setEmail(email);
    }

    // Getter para o ID do professor
    public String getId() {
        return id;
    }

    // Setter para o ID do professor com validação
    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do professor não pode ser vazio.");
        }
        this.id = id;
    }

    // Getter para o nome do professor
    public String getNome() {
        return nome;
    }

    // Setter para o nome do professor com validação
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do professor não pode ser vazio.");
        }
        this.nome = nome;
    }

    // Getter para o e-mail do professor
    public String getEmail() {
        return email;
    }

    // Setter para o e-mail do professor com validação
    public void setEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("E-mail do professor não pode ser vazio.");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("E-mail do professor inválido.");
        }
        this.email = email;
    }

    // Método privado para validar o formato do e-mail
    private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.compile(regex).matcher(email).matches();
    }
}
