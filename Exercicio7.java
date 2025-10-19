import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Exercicio7 {

    private static final int TAMANHO_FILA = 20;

    public static void main(String[] args) {
        
        System.out.println("----------------------------------------");
        System.out.println("Exercício 7: Inversão de Fila (20 posições)");
        System.out.println("----------------------------------------");

        Queue<Integer> F = new LinkedList<>();
        popularFila(F, TAMANHO_FILA);

        System.out.println("Fila F Original (Frente -> Fundo):");
        imprimirFila(F);
        
        inverterFila(F);
        
        System.out.println("\nFila F Invertida (Frente -> Fundo):");
        imprimirFila(F);
    }

    private static void popularFila(Queue<Integer> fila, int tamanho) {
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            fila.add(random.nextInt(100));
        }
    }

    public static void inverterFila(Queue<Integer> F) {
        Pilha<Integer> P = new Pilha<>();
        
        while (!F.isEmpty()) {
            P.empilhar(F.remove()); 
        }
        
        while (!P.estaVazia()) {
            F.add(P.desempilhar()); 
        }
    }
    
    private static void imprimirFila(Queue<Integer> fila) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ FRENTE -> ");
        for (Integer item : fila) {
            sb.append(item).append(", ");
        }
        if (sb.length() > 10) { 
            sb.setLength(sb.length() - 2); 
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }
}