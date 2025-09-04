import java.util.HashMap;
import java.util.Map;

import javax.swing.text.StyledEditorKit;

public class HashMapExemplo {
    
    public static void main(String[] args) {
        // alunos.adicionar("Pedro", 2)

        Map<String, Integer> alunosA = new HashMap<>();
        alunosA.put("Pedro", 7);
        alunosA.put("Joao", 8);
        // System.out.println("alunosA " + alunosA);

        Map<String, Integer> alunosB = new HashMap<>();
        alunosB.put("Maria", 7);
        alunosB.put("Jonas", 8);
        // System.out.println("alunosB " + alunosB);


        Map<String, Map<String, Integer>> turmas = new HashMap<>();
        turmas.put("Turma A", alunosA);
        turmas.put("Turma B", alunosB);

        System.out.println(turmas);

        // looop

        System.out.println(turmas.keySet());
        for (String turmaNome : turmas.keySet()) {
            System.out.println(turmaNome);

            Map<String, Integer> alunos = turmas.get(turmaNome);
            for (String alunoNome : alunos.keySet()) {
                System.out.println(" " + alunoNome + " - " + alunos.get(alunoNome));
            }
        }
    }





}
