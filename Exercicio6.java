import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Exercicio6 {

    private static final int NUMERO_DE_CADA_TIPO = 1000;

    public static void main(String[] args) {
        
        System.out.println("----------------------------------------");
        System.out.println("Exercício 6: Processamento Positivo/Negativo");
        System.out.println("----------------------------------------");

        Queue<Integer> F = new LinkedList<>();
        Pilha<Integer> P = new Pilha<>();

        popularFila(F, NUMERO_DE_CADA_TIPO);
        System.out.println("Fila F inicializada com " + F.size() + " números (1000+ e 1000-).");

        int totalImpresso = 0;
        
        while (!F.isEmpty()) {
            Integer itemFila = F.peek();

            if (itemFila == null) {
                break;
            }

            if (itemFila > 0) {
                F.remove();
                P.empilhar(itemFila);
                System.out.println("[+]: Fila -> Pilha. Item: " + itemFila);

            } else if (itemFila < 0) {
                F.remove(); 
                
                if (!P.estaVazia()) {
                    Integer itemPilha = P.desempilhar();
                    System.out.println("[-]: Pilha -> Impressão. Item impresso: " + itemPilha);
                    totalImpresso++;
                } else {
                    System.out.println("[-]: Pilha P vazia. Número negativo (" + itemFila + ") descartado.");
                }
            }
        }

        System.out.println("\n--- Resumo Final ---");
        System.out.println("Fila F restante: " + F.size());
        System.out.println("Pilha P restante: " + P.tamanho());
        System.out.println("Total de números impressos (desempilhados): " + totalImpresso);

    }
    
    private static void popularFila(Queue<Integer> fila, int n) {
        Random random = new Random();
        LinkedList<Integer> temp = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            int valorPositivo = random.nextInt(1000) + 1;
            int valorNegativo = -(random.nextInt(1000) + 1);

            temp.add(valorPositivo);
            temp.add(valorNegativo);
        }
        
        Collections.shuffle(temp);

        fila.addAll(temp);
    }
}