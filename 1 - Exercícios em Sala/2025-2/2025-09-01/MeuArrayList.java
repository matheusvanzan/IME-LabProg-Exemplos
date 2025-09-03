import java.util.ArrayList;
import java.util.Arrays;

public class MeuArrayList {
    
    public static void main(String[] args) {

        // String l1[] = {"Item 2", "Item 2"};
        // System.out.println(l1);
        // System.out.println(Arrays.toString(l1));










        


        // String l1[] = {"a", "b"};
        // System.out.println(l1);
        
        
        ArrayList<String> lista = new ArrayList<String>();

        // adicionar itens
        lista.add("Item 1");
        lista.add("Item 2");
        System.out.println(lista);

        // acesso indexado
        System.out.printf("1 - %s\n", lista.get(1));

        // remover
        lista.remove(1);
        System.out.println(lista);

    }
}
