import java.io.File;  
import java.io.FileWriter;  
import java.io.IOException;  
import java.util.Scanner;  

public class FileHelper {

  public static void main(String[] args) {
    try {
      // Create the file
      createFile("arquivo.txt");

      // Write to the file
      writeToFile("This is the first line of the file.");

      // Read from the file
      readFromFile();

    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  // Method to create the file
  public static void createFile(String fileName) throws IOException {
    File myObj = new File(fileName);
    if (myObj.createNewFile()) {
      System.out.println("File created: " + myObj.getName());
    } else {
      System.out.println("File already exists.");
    }
  }

  // Method to write to the file
  public static void writeToFile(String content) {
    try {
      FileWriter myWriter = new FileWriter("arquivo.txt");
      myWriter.write(content);
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred while writing to the file.");
      e.printStackTrace();
    }
  }

  // Method to read from the file
  public static void readFromFile() {
    try {
      File myObj = new File("arquivo.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println("Read from file: " + data);
      }
      myReader.close();
    } catch (IOException e) {
      System.out.println("An error occurred while reading from the file.");
      e.printStackTrace();
    }
  }
}
