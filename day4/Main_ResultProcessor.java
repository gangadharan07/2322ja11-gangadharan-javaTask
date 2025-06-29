package day4;
import java.io.*;

public class Main_ResultProcessor {
    public static void main(String[] args) {
        String inputFile = "marks.txt";
        String outputFile = "results.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                // Split line: ID Name Mark1 Mark2 Mark3
                String[] parts = line.split(" ");
                if (parts.length != 5) continue; // skip invalid lines

                String id = parts[0];
                String name = parts[1];
                int m1 = Integer.parseInt(parts[2]);
                int m2 = Integer.parseInt(parts[3]);
                int m3 = Integer.parseInt(parts[4]);

                int total = m1 + m2 + m3;
                float average = total / 3.0f;
                String result = average >= 40 ? "PASS" : "FAIL";

                String output = id + " " + name + " Total: " + total + " Avg: " + average + " Result: " + result;
                writer.write(output);
                writer.newLine();
            }

            reader.close();
            writer.close();

            System.out.println("Results written to " + outputFile);

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file.");
        }
    }
}
