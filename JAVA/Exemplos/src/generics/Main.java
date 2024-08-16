package generics;

public class Main {

    public static void main(String[] args) {
        Integer vetorInt[] = {1, 2, 3, 4};
        Double[] vetorPontoFlutuante = {1.0, 2.0, 3.0, 4.0};
        Character vetorChar[] = {'a', 'b', 'c', 'd'};


        VetorTools toolsInt = new VetorTools<>(vetorInt);
        toolsInt.imprimir();

        System.out.println(toolsInt.getFirstItem()+1);


    }
}
