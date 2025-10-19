import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Exercicio3 {

    private static Queue<Aviao> filaDecolagem = new LinkedList<>();
    private static int proximoID = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        System.out.println("----------------------------------------------");
        System.out.println("Exercício 3: Controle da Pista de Decolagem");
        System.out.println("----------------------------------------------");

        do {
            exibirMenu();
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcao) {
                    case 1:
                        listarNumeroAvioes();
                        break;
                    case 2:
                        autorizarDecolagem();
                        break;
                    case 3:
                        adicionarAviao(scanner);
                        break;
                    case 4:
                        listarAvioesNaFila();
                        break;
                    case 5:
                        listarPrimeiroAviao();
                        break;
                    case 0:
                        System.out.println("Encerrando o controle de tráfego aéreo.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número de 0 a 5.");
                scanner.next();
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("Menu de Controle de Pista:");
        System.out.println("1 - Listar o número de aviões aguardando");
        System.out.println("2 - Autorizar a decolagem do primeiro avião");
        System.out.println("3 - Adicionar um avião à fila");
        System.out.println("4 - Listar todos os aviões na fila");
        System.out.println("5 - Listar características do primeiro avião");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void listarNumeroAvioes() {
        System.out.println("=> Aviões aguardando na fila: " + filaDecolagem.size());
    }

    private static void autorizarDecolagem() {
        if (filaDecolagem.isEmpty()) {
            System.out.println("=> Pista vazia. Nenhum avião para decolar.");
            return;
        }
        Aviao aviaoDecolado = filaDecolagem.remove(); 
        System.out.println("=> Decolagem autorizada: " + aviaoDecolado.toString());
    }

    private static void adicionarAviao(Scanner scanner) {
        System.out.print("Digite o nome do avião: ");
        String nome = scanner.nextLine();
        
        Aviao novoAviao = new Aviao(nome, proximoID++);
        
        filaDecolagem.add(novoAviao); 
        System.out.println("=> Avião adicionado à fila: " + novoAviao.toString());
    }

    private static void listarAvioesNaFila() {
        if (filaDecolagem.isEmpty()) {
            System.out.println("=> A fila de espera está vazia.");
            return;
        }
        System.out.println("=> Aviões aguardando (Primeiro -> Último):");
        int i = 1;
        for (Aviao aviao : filaDecolagem) {
            System.out.println("   " + i++ + ". " + aviao.toString());
        }
    }

    private static void listarPrimeiroAviao() {
        if (filaDecolagem.isEmpty()) {
            System.out.println("=> A fila está vazia. Não há primeiro avião.");
            return;
        }
        Aviao primeiro = filaDecolagem.peek(); 
        System.out.println("=> Características do primeiro avião na fila: " + primeiro.toString());
    }
}