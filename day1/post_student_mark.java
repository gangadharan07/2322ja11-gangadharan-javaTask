package day1;

import java.util.Scanner;

public class post_student_mark {

    // Function to get grade based on average
    static String getGrade(double avg) {
        if (avg >= 90) return "A+";
        else if (avg >= 80) return "A";
        else if (avg >= 70) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F (Fail)";
    }

    // Function to check if student passed all subjects
    static boolean isPassed(int[] marks) {
        for (int mark : marks) {
            if (mark < 35) return false;
        }
        return true;
    }

    // Function to print result
    static void printResult(String name, String[] subjects, int[] marks) {
        int total = 0;
        System.out.println("\n--- Student Report ---");
        System.out.println("Name: " + name);
        System.out.println("Marks:");

        for (int i = 0; i < marks.length; i++) {
            System.out.print(subjects[i] + ": " + marks[i]);
            if (marks[i] < 35)
                System.out.println(" (Fail)");
            else
                System.out.println(" (Pass)");
            total += marks[i];
        }

        double avg = total / 5.0;
        String grade = getGrade(avg);
        boolean passStatus = isPassed(marks);

        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + grade);
        System.out.println("Overall Result: " + (passStatus ? "PASS ✅" : "FAIL ❌"));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        // Define subject names
        String[] subjects = {"Tamil", "English", "Maths", "Science", "Social"};
        int[] marks = new int[5];

        // Get marks input for each subject
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter marks for " + subjects[i] + ": ");
            marks[i] = sc.nextInt();
        }

        printResult(name, subjects, marks);
        sc.close();
    }
    
}
