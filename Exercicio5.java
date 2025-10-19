import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class Exercicio5 {

    private static final int NUMERO_DE_SORTEIOS = 1000;
    private static final int MAX_VALOR_ALEATORIO = 1000;

    public static void main(String[] args) {
        
        System.out.println("----------------------------------------");
        System.out.println("Exercício 5: Separação de Duplicados");
        System.out.println("----------------------------------------");

        Queue<Integer> F = new LinkedList<>();
        Pilha<Integer> P = new Pilha<>();
        Set<Integer> rastreadorF = new HashSet<>();
        
        Random random = new Random();

        for (int i = 0; i < NUMERO_DE_SORTEIOS; i++) {
            int numeroSorteado = random.nextInt(MAX_VALOR_ALEATORIO);
            
            if (!rastreadorF.contains(numeroSorteado)) {
                F.add(numeroSorteado);
                rastreadorF.add(numeroSorteado);
            } else {
                P.empilhar(numeroSorteado);
            }
        }
        
        System.out.println("Sorteio concluído. Total de números sorteados: " + NUMERO_DE_SORTEIOS);
        System.out.println("Números distintos (Fila F): " + F.size());
        System.out.println("Números repetidos (Pilha P): " + P.tamanho());

        System.out.println("\n--- Conteúdo da Fila F (Distintos) ---");
        imprimirFila(F);
        
        System.out.println("\n--- Conteúdo da Pilha P (Repetidos) ---");
        imprimirPilha(P);
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
    
    private static void imprimirPilha(Pilha<Integer> pilha) {
        Pilha<Integer> temp = new Pilha<>();
        StringBuilder sb = new StringBuilder();

        while (!pilha.estaVazia()) {
            temp.empilhar(pilha.desempilhar());
        }

        sb.append("[ TOPO -> ");
        
        while (!temp.estaVazia()) {
            Integer item = temp.desempilhar();
            sb.append(item).append(", ");
            pilha.empilhar(item);
        }
        
        if (sb.length() > 10) { 
            sb.setLength(sb.length() - 2); 
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }
}