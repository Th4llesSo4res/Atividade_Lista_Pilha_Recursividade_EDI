public class Aviao {
    private String nome;
    private int identificador;

    // Construtor
    public Aviao(String nome, int identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    // Método para exibir as características do avião
    @Override
    public String toString() {
        return "ID: " + identificador + " | Nome: " + nome;
    }
}