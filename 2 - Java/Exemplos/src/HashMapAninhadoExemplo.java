import java.util.HashMap;
import java.util.Map;

public class HashMapAninhadoExemplo {
    public static void main(String[] args) {
        // HashMap externo: aluno -> (disciplina -> nota)
        Map<String, Map<String, Double>> boletim = new HashMap<>();

        // Adicionando disciplinas e notas para "João"
        Map<String, Double> notasJoao = new HashMap<>();
        notasJoao.put("Matemática", 8.5);
        notasJoao.put("História", 7.0);
        boletim.put("João", notasJoao);

        // Adicionando disciplinas e notas para "Maria"
        Map<String, Double> notasMaria = new HashMap<>();
        notasMaria.put("Matemática", 9.0);
        notasMaria.put("História", 8.5);
        boletim.put("Maria", notasMaria);

        // Iterando e exibindo os dados
        for (String aluno : boletim.keySet()) {
            System.out.println("Aluno: " + aluno);
            Map<String, Double> notas = boletim.get(aluno);
            for (String disciplina : notas.keySet()) {
                System.out.println("  " + disciplina + " -> " + notas.get(disciplina));
            }
        }
    }
}
