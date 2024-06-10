package Model;

public class Disciplina {
    private String codigo;
    private String nome;
    private int cargaHoraria;

    // Construtor para inicializar os atributos com validação
    public Disciplina(String codigo, String nome, int cargaHoraria) {
        setCodigo(codigo);
        setNome(nome);
        setCargaHoraria(cargaHoraria);
    }

    // Getter para o código da disciplina
    public String getCodigo() {
        return codigo;
    }

    // Setter para o código da disciplina com validação
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("Código da disciplina não pode ser vazio.");
        }
        this.codigo = codigo;
    }

    // Getter para o nome da disciplina
    public String getNome() {
        return nome;
    }

    // Setter para o nome da disciplina com validação
    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome da disciplina não pode ser vazio.");
        }
        this.nome = nome;
    }

    // Getter para a carga horária da disciplina
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    // Setter para a carga horária da disciplina com validação
    public void setCargaHoraria(int cargaHoraria) {
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("Carga horária da disciplina deve ser positiva.");
        }
        this.cargaHoraria = cargaHoraria;
    }
}
