import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Exercicio4 {

    private static final int TAMANHO_FILA = 100;

    public static void main(String[] args) {
        
        System.out.println("----------------------------------------");
        System.out.println("Exercício 4: Inversão de Fila (F1 para F2)");
        System.out.println("----------------------------------------");

        Queue<Integer> F1 = new LinkedList<>();
        popularFila(F1, TAMANHO_FILA);

        System.out.println("Fila F1 (Primeiros 10 elementos):");
        imprimirPrimeirosElementos(F1, 10);
        
        Queue<Integer> F2 = inverterFila(F1);

        System.out.println("\nFila F2 (Primeiros 10 elementos invertidos):");
        imprimirPrimeirosElementos(F2, 10);
        
        System.out.println("\n--- Status Final ---");
        System.out.println("Tamanho de F1 (Original, agora vazia): " + F1.size());
        System.out.println("Tamanho de F2 (Invertida): " + F2.size());
    }

    private static void popularFila(Queue<Integer> fila, int tamanho) {
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            fila.add(random.nextInt(1000));
        }
    }

    public static Queue<Integer> inverterFila(Queue<Integer> F1) {
        Pilha<Integer> P = new Pilha<>();
        
        while (!F1.isEmpty()) {
            P.empilhar(F1.remove());
        }
        
        Queue<Integer> F2 = new LinkedList<>();
        
        while (!P.estaVazia()) {
            F2.add(P.desempilhar());
        }
        
        return F2;
    }
    
    private static void imprimirPrimeirosElementos(Queue<Integer> fila, int n) {
        int count = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Integer item : fila) {
            if (count >= n) {
                break;
            }
            sb.append(item).append(", ");
            count++;
        }
        if (fila.size() > n) {
             sb.append("..., ");
        }
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 2); 
        }
        sb.append(" ]");
        
        System.out.println(sb.toString());
    }
}