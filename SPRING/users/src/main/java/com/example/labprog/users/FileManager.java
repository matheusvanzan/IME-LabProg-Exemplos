package com.example.labprog.users;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public static void main(String[] args) {

    }

    public static ArrayList<String> readFromFile(String fileName) {
        ArrayList<String> lines = new ArrayList<String>();

        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
 
            String line; 
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
