package day4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFileExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filePath = "output.txt"; // The file where strings will be written

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

            System.out.println("Enter lines to write to the file (type 'exit' to stop):");

            while (true) {
                String line = sc.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line);
                writer.newLine(); // move to next line
            }

            writer.close();
            System.out.println("Strings written to file successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
