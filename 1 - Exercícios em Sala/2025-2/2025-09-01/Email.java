import java.util.Scanner;

public class Email {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.println("Entre com seu email:");
        String email = in.nextLine();

        if (!email.contains("@")) {
            System.out.println("Email não contem @");
            return;
        }

        if (!email.endsWith(".com") && !email.startsWith(".br")) {
            System.out.println("Email não contem .com ou .br");
            return;
        }

        System.out.println("Email verificado com sucesso!");
        
    }
}
