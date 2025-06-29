package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) {
        String filePath = "sample.txt"; // Make sure this file exists in your project directory

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;

            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
