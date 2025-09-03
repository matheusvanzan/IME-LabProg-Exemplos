import java.util.*;

public class PermutacaoNumeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Arrays dinâmicos para armazenar histórico
        List<Integer> numerosA = new ArrayList<>();
        List<Integer> numerosB = new ArrayList<>();
        List<Boolean> resultados = new ArrayList<>();

        while (true) {
            System.out.print("Digite o primeiro número positivo (ou -1 para sair): ");
            int n1 = sc.nextInt();
            if (n1 == -1) break; // condição de saída

            System.out.print("Digite o segundo número positivo: ");
            int n2 = sc.nextInt();

            if (n1 < 0 || n2 < 0) {
                System.out.println("Apenas números positivos são permitidos!");
                continue;
            }

            // Verificar permutação
            boolean ehPermutacao = saoPermutacao(n1, n2);

            // Armazenar histórico
            numerosA.add(n1);
            numerosB.add(n2);
            resultados.add(ehPermutacao);

            // Mostrar histórico
            System.out.println("\n=== Histórico de verificações ===");
            for (int i = 0; i < numerosA.size(); i++) {
                System.out.printf("%d e %d -> %s%n",
                        numerosA.get(i),
                        numerosB.get(i),
                        resultados.get(i) ? "São permutação" : "Não são");
            }
            System.out.println();
        }

        sc.close();
    }

    // Função auxiliar para verificar se dois inteiros são permutação
    public static boolean saoPermutacao(int a, int b) {
        char[] arrA = String.valueOf(a).toCharArray();
        char[] arrB = String.valueOf(b).toCharArray();
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        return Arrays.equals(arrA, arrB);
    }
}
