// Crie um programa em Java para validação de emails:
// - Peça ao usuário digitar um e-mail.
// - Verifique se contém o caractere @.
// - Verifique se termina com ".com" ou “.br”.
// - Exiba se o e-mail é válido ou inválido.

import java.util.Scanner;

public class ValidacaoEmail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada do usuário
        System.out.print("Digite um e-mail: ");
        String email = sc.nextLine();

        // Verificações
        boolean temArroba = email.contains("@");          // contém '@' ?
        boolean terminaCom = email.endsWith(".com");      // termina com ".com" ?

        if (temArroba && terminaCom) {
            System.out.println("E-mail válido");
        } else {
            System.out.println("E-mail inválido");
        }

        sc.close();
    }
}
