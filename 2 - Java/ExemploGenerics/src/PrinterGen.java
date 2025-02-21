public class PrinterGen<T> {

    public void print(T[] vetor){
        for(T e: vetor) { System.out.println(e); }
    }

    public static void main(String[] args) {
        Integer[] vetorInt = {1, 2, 3, 4};
        Character[] vetorChar = {'a', 'b', 'c', 'd'};

        PrinterGen<Integer> printerInt = new PrinterGen<>();  
        PrinterGen<Character> printerChar = new PrinterGen<>();  
         
        printerInt.print(vetorInt);
        printerChar.print(vetorChar);
    }
}