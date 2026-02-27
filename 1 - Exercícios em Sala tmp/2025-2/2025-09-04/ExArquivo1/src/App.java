import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static void writeToFile(String[] items) {

        try{
            FileWriter w = new FileWriter("file.txt", true);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write("Minha segunda linha");
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("Arquivo não existe");
        }
    }

    public static void readFromFile() {

        try {
            FileReader r = new FileReader("file.txt");
            BufferedReader br = new BufferedReader(r);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Linha -> " + line);
            }
            r.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Erro");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String[] items = {"Item 1", "Item 3", "Item 3"};
        writeToFile(items);

        readFromFile();
    }
}
