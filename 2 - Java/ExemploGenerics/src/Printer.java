public class Printer {

    public void print(int vetor[]){
        for(int e: vetor) { System.out.println(e); }
    }

    public static void main(String[] args) {  
        int[] vetor = {1, 2, 3, 4};
        
        Printer printer = new Printer();  
        printer.print(vetor);

        char[] vetor2 = {'a', 'b', 'c', 'd'};
        printer.print(vetor2);

    }
}