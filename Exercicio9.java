import java.util.Arrays;
import java.util.List;

public class Exercicio9 {

    public static void main(String[] args) {
        
        System.out.println("----------------------------------------");
        System.out.println("Exercício 9: Soma de Lista (Recursiva)");
        System.out.println("----------------------------------------");
        
        List<Integer> lista1 = Arrays.asList(1, 2, 3, 4);
        int soma1 = somaRecursiva(lista1);
        System.out.println("Lista: " + lista1 + " | Soma: " + soma1);

        List<Integer> lista2 = Arrays.asList(10, -5, 15, 0);
        int soma2 = somaRecursiva(lista2);
        System.out.println("Lista: " + lista2 + " | Soma: " + soma2);
        
        List<Integer> listaVazia = Arrays.asList();
        int somaVazia = somaRecursiva(listaVazia);
        System.out.println("Lista: " + listaVazia + " | Soma: " + somaVazia);
    }
    
    public static int somaRecursiva(List<Integer> lista) {
        if (lista.isEmpty()) {
            return 0;
        }
        
        int cabeca = lista.get(0);
        
        List<Integer> cauda = lista.subList(1, lista.size());
        
        return cabeca + somaRecursiva(cauda);
    }
}