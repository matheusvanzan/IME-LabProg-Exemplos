import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExemploArquivo {

    static final String fileName = "MyFile.txt";
    static final Boolean fileAppend = true;

    public static void main(String[] args) {

        // Escrita
        String[] items = {"Volvo", "BMW", "Ford", "Mazda"};
        writeToFile(items);

        // Leitura
        ArrayList<String> fileItems = readFromFile();
        System.out.println(fileItems.toString());
    }

    public static void writeToFile(String[] items) {
        try {
            FileWriter writer = new FileWriter(fileName, fileAppend);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            for (String item: items) {
                bufferedWriter.write(item);
                bufferedWriter.newLine();
            }
 
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readFromFile() {
        ArrayList<String> items = new ArrayList<String>();

        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line; 
            while ((line = bufferedReader.readLine()) != null) {
                items.add(line);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }

}
