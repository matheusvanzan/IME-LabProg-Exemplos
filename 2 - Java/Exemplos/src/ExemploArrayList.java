import java.util.ArrayList;

public class ExemploArrayList {

    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        
        System.out.println(numeros.size()); // 3
        System.out.println(numeros); // [1, 2, 3]

        numeros.remove(2); // remove o indice 2

        System.out.println(numeros.size()); // 2
        System.out.println(numeros); // [1, 2]

        for (Integer item: numeros) {
            System.out.println(item);
        }
    }
}
