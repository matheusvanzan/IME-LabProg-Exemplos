import java.util.Arrays;
import java.util.Scanner;

public class Exemplo1 {

    public static int soma(int a, int b){ 
        return a + b;
    }

    public static int somaLista(int[] minhaLista) {

        int acc = 0;
        // for (int i=0; i<minhaLista.length; i++) {
        //     acc += minhaLista[i];
        // }

        for (int itemDaLista: minhaLista) {
            acc += itemDaLista;
        }

        return acc;
    }

    public static int somaItens(int... itens) {
        /** somaItens(a, b, c, ...) */
        int acc = 0;
        for (int i: itens) {
            acc += i;
        }
        return acc;
    }

    public static void main(String[] args) {

        int[] minhaLista = {1, 3, 7, 4};

        // Integer a = 23;
        // String s = a.toString();

        // Integer.toString(23);

        // for (int i=0; i<minhaLista.length; i++) {
        //     System.out.println("Indice: " + Integer.toString(i));
        //     System.out.println(minhaLista[i]);
        // }

        int soma = somaLista(minhaLista);
        System.out.println(Arrays.toString(minhaLista));
        System.out.println("A soma é " + Integer.toString(soma));

        // int a=1, b=5, c=7;
        // int soma2 = somaItens(a, c);
        // System.out.println(soma2);
    }

}