public class PrinterChar {

    public void print(char vetor[]){
        for(char e: vetor) { System.out.println(e); }
    }

    public static void main(String[] args) {  
        char[] vetorChar = {'a', 'b', 'c', 'd'};
        
        PrinterChar printerChar = new PrinterChar();  
        printerChar.print(vetorChar);
    }
}