public class PrinterInt {

    public void print(int vetor[]){
        for(int e: vetor) { System.out.println(e); }
    }

    public static void main(String[] args) {  
        int[] vetorInt = {1, 2, 3, 4};
        
        PrinterInt printerInt = new PrinterInt();  
        printerInt.print(vetorInt);
    }
}