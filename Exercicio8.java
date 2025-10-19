import java.util.Random;

public class Exercicio8 {

    private static final int NUMERO_DE_SORTEIOS = 1000;
    private static final int MIN_VALOR = -100;
    private static final int MAX_VALOR = 100;

    public static void main(String[] args) {
        
        System.out.println("----------------------------------------");
        System.out.println("Exercício 8: Processamento com Duas Pilhas (P e N)");
        System.out.println("----------------------------------------");

        TestaPilha pilhas = new TestaPilha();
        Random random = new Random();
        int zerosEncontrados = 0;
        int remocoesEfetivas = 0;

        for (int i = 0; i < NUMERO_DE_SORTEIOS; i++) {
            int numeroSorteado = random.nextInt(MAX_VALOR - MIN_VALOR + 1) + MIN_VALOR;
            
            if (numeroSorteado > 0) {
                pilhas.P.empilhar(numeroSorteado);
                
            } else if (numeroSorteado < 0) {
                pilhas.N.empilhar(numeroSorteado);

            } else {
                zerosEncontrados++;

                Integer itemP = null;
                Integer itemN = null;

                if (!pilhas.P.estaVazia()) {
                    itemP = pilhas.P.desempilhar();
                }
                
                if (!pilhas.N.estaVazia()) {
                    itemN = pilhas.N.desempilhar();
                }

                if (itemP != null || itemN != null) {
                    System.out.println("[ZERO] Retirados: P -> " + 
                                       (itemP != null ? itemP : "Vazio") + 
                                       " | N -> " + 
                                       (itemN != null ? itemN : "Vazio"));
                    remocoesEfetivas++;
                } else {
                    System.out.println("[ZERO] Pilhas P e N estavam vazias. Nenhuma remoção.");
                }
            }
        }
        
        System.out.println("\n--- Resumo Final ---");
        System.out.println("Sorteios de ZERO encontrados: " + zerosEncontrados);
        System.out.println("Eventos de remoção efetiva: " + remocoesEfetivas);
        System.out.println("Pilha P (Positivos) restantes: " + pilhas.P.tamanho());
        System.out.println("Pilha N (Negativos) restantes: " + pilhas.N.tamanho());
    }
}