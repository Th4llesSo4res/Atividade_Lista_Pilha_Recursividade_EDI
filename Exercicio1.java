import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("-------------------------------------------");
        System.out.println("Exercício 1: Inversão e Palíndromo (Pilha)");
        System.out.println("-------------------------------------------");
        System.out.print("Digite uma sequência de caracteres: ");
        String textoOriginal = scanner.nextLine();

        Pilha<Character> pilha = new Pilha<>();
        
        for (char c : textoOriginal.toCharArray()) {
            pilha.empilhar(c);
        }

        
        System.out.print("\nA) Texto na ordem inversa: ");
        String textoInvertido = gerarTextoInvertido(pilha);
        System.out.println(textoInvertido);
        
        
        boolean ehPalindromo = verificarPalindromo(textoOriginal, textoInvertido);
        System.out.println("\nB) Verificação de Palíndromo:");
        System.out.println("O texto \"" + textoOriginal + "\" é um palíndromo? " + (ehPalindromo ? "SIM" : "NÃO"));
        
        scanner.close();
    }

    private static String gerarTextoInvertido(Pilha<Character> pilha) {
        StringBuilder sb = new StringBuilder();
        while (!pilha.estaVazia()) {
            sb.append(pilha.desempilhar());
        }
        return sb.toString();
    }
    
    private static boolean verificarPalindromo(String original, String invertido) {
        
        String limpoOriginal = original
                                .replaceAll("[\\s.]", "") 
                                .toLowerCase();
        
        Pilha<Character> pilhaLimpa = new Pilha<>();
        
                for (char c : original.toCharArray()) {
           
            if (Character.isLetterOrDigit(c)) { 
                pilhaLimpa.empilhar(Character.toLowerCase(c));
            }
        }
        
       
        StringBuilder sbInvertidoLimpo = new StringBuilder();
        while (!pilhaLimpa.estaVazia()) {
            sbInvertidoLimpo.append(pilhaLimpa.desempilhar());
        }
        String textoInvertidoLimpo = sbInvertidoLimpo.toString();
        
       
        return limpoOriginal.equals(textoInvertidoLimpo);
    }
}