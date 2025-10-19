public class Exercicio10 {

    public static void main(String[] args) {
        
        System.out.println("----------------------------------------");
        System.out.println("Exercício 10: Potenciação (a^b) Recursiva");
        System.out.println("----------------------------------------");
        
        int base1 = 2;
        int expoente1 = 3;
        int resultado1 = potenciaRecursiva(base1, expoente1);
        System.out.println(base1 + "^" + expoente1 + " = " + resultado1);

        int base2 = 5;
        int expoente2 = 0;
        int resultado2 = potenciaRecursiva(base2, expoente2);
        System.out.println(base2 + "^" + expoente2 + " = " + resultado2);
        
        int base3 = 4;
        int expoente3 = 4;
        int resultado3 = potenciaRecursiva(base3, expoente3);
        System.out.println(base3 + "^" + expoente3 + " = " + resultado3);
    }
    
    public static int potenciaRecursiva(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Apenas números inteiros positivos são permitidos (a e b).");
        }
        
        if (b == 0) {
            return 1;
        }
        
        return a * potenciaRecursiva(a, b - 1);
    }
}