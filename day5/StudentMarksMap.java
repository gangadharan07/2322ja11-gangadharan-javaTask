package day5;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentMarksMap {
    public static void main(String[] args) {
        HashMap<String, Integer> studentMarks = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student name and marks (type 'done' to finish):");

        while (true) {
            System.out.print("Student Name: ");
            String name = sc.nextLine().trim();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Marks: ");
            int marks = sc.nextInt();
            sc.nextLine(); // consume leftover newline

            studentMarks.put(name, marks);
        }

        // Display all entries
        System.out.println("\nStudent Marks:");
        for (Map.Entry<String, Integer> entry : studentMarks.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }

        // Compute average
        if (!studentMarks.isEmpty()) {
            int total = 0;
            for (int marks : studentMarks.values()) {
                total += marks;
            }
            double average = total / (double) studentMarks.size();
            System.out.printf("Average Marks: %.2f%n", average);
        } else {
            System.out.println("No data to compute average.");
        }

        sc.close();
    }
}
