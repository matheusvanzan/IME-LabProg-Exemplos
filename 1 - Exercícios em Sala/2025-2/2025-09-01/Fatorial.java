
import java.util.Scanner;

public class Fatorial {

    static int fatRec(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        return n*fatRec(n-1);
    }

    static int fatIt(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        int acc = 1;
        for (int i=1; i<=n; i++) {
            acc = i*acc;
        }
 
        return acc;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Insira um número:");
        int n = in.nextInt();

        int output = fatRec(n);
        System.out.printf("O fatRec(%d) = %d", n, output);

        in.close();
    }
}