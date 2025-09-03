import java.util.Scanner;

public class WhatsAppLink {

    // Verifica se só tem dígitos
    static boolean somenteDigitos(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    // Gera o link do WhatsApp Web (só trocando espaços)
    static String gerarLinkWhatsApp(String numero, String mensagem) {
        if (!somenteDigitos(numero)) {
            throw new IllegalArgumentException("Número deve conter apenas dígitos!");
        }
        String mensagemCodificada = mensagem.replace(" ", "%20");
        return "https://wa.me/" + numero + "?text=" + mensagemCodificada;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número (apenas dígitos, ex: 5521999999999): ");
        String numero = sc.nextLine();

        System.out.print("Digite a mensagem: ");
        String mensagem = sc.nextLine();

        try {
            String url = gerarLinkWhatsApp(numero, mensagem);
            System.out.println("\nLink gerado:");
            System.out.println(url);

        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}
