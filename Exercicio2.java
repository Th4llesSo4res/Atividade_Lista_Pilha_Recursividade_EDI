import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {
        Pilha<Integer> pilhaOriginal = new Pilha<>();
        pilhaOriginal.empilhar(10);
        pilhaOriginal.empilhar(20);
        pilhaOriginal.empilhar(30);
        pilhaOriginal.empilhar(40);
        pilhaOriginal.empilhar(50);

        System.out.println("----------------------------------------");
        System.out.println("Exercício 2: Remoção de Item da Pilha");
        System.out.println("----------------------------------------");
        System.out.println("Pilha Original (Topo -> Base): 50, 40, 30, 20, 10");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a chave (item) 'c' a ser removida: ");
        
        if (scanner.hasNextInt()) {
            int chaveC = scanner.nextInt();
            
            removerItem(pilhaOriginal, chaveC);

            System.out.println("\nItem " + chaveC + " removido.");
            System.out.println("Pilha Final (Topo -> Base):");
            imprimirPilha(pilhaOriginal);
        } else {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
        }
        
        scanner.close();
    }
    
    public static void removerItem(Pilha<Integer> pilhaOriginal, Integer chaveC) {
        Pilha<Integer> pilhaAuxiliar = new Pilha<>();
        boolean itemRemovido = false;

        while (!pilhaOriginal.estaVazia()) {
            Integer item = pilhaOriginal.desempilhar();
            
            if (item.equals(chaveC) && !itemRemovido) {
                itemRemovido = true;
            } else {
                pilhaAuxiliar.empilhar(item);
            }
        }

        while (!pilhaAuxiliar.estaVazia()) {
            pilhaOriginal.empilhar(pilhaAuxiliar.desempilhar());
        }
    }
    
    private static void imprimirPilha(Pilha<Integer> pilha) {
        Pilha<Integer> temp = new Pilha<>();
        
        while (!pilha.estaVazia()) {
            temp.empilhar(pilha.desempilhar());
        }
        
        StringBuilder sb = new StringBuilder();
        while (!temp.estaVazia()) {
            Integer item = temp.desempilhar();
            sb.append(item).append(" ");
            pilha.empilhar(item);
        }
        
        System.out.println(sb.toString().trim());
    }
}