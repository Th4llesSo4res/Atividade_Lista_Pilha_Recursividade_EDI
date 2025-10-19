import java.util.ArrayList;

public class Pilha<T> {
    // Usamos um ArrayList para armazenar os elementos da pilha.
    // O tipo genérico <T> permite que esta Pilha armazene qualquer tipo de objeto (String, Character, etc.)
    private ArrayList<T> elementos;

    // Construtor
    public Pilha() {
        this.elementos = new ArrayList<>();
    }

    // Operação: Empilhar (Push) - Adiciona um elemento ao topo
    public void empilhar(T elemento) {
        this.elementos.add(elemento);
    }

    // Operação: Desempilhar (Pop) - Remove e retorna o elemento do topo
    public T desempilhar() {
        if (estaVazia()) {
            throw new IllegalStateException("A pilha está vazia. Não é possível desempilhar.");
        }
        // Retorna e remove o último elemento (o topo da pilha)
        return this.elementos.remove(this.elementos.size() - 1);
    }

    // Operação: Espiar (Peek) - Retorna o elemento do topo sem remover
    public T topo() {
        if (estaVazia()) {
            return null; // Ou lançar uma exceção, dependendo da sua preferência
        }
        return this.elementos.get(this.elementos.size() - 1);
    }

    // Operação: Está Vazia (IsEmpty)
    public boolean estaVazia() {
        return this.elementos.isEmpty();
    }

    // Método para obter o tamanho da pilha (opcional, mas útil)
    public int tamanho() {
        return this.elementos.size();
    }
}