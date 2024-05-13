package Model;

public class Professor {
    private String id;
    private String nome;
    private String email;

    public Professor(String id, String nome, String email) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do professor não pode ser vazio.");
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome do professor não pode ser vazio.");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("E-mail do professor não pode ser vazio.");
        }
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

}