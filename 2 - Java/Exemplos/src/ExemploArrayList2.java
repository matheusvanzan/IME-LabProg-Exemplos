import java.util.ArrayList;
import java.util.Scanner;

public class ExemploArrayList2 {

    public static void main(String[] args) {

        Scanner input = new Scanner( System.in );
        ArrayList<Integer> numeros = new ArrayList<Integer>();

        Boolean stopExecution = false;
        while (!stopExecution) {
            System.out.println("Insira um número. (Digite 0 para sair)");

            int n = input.nextInt();
            numeros.add(n);

            System.out.println("Lista atualizada: " + numeros.toString());

            if (n == 0) { stopExecution = true ;}
        }

        input.close();
    }

}
