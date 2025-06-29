package day3;

import java.util.Scanner;

public class Main_StudentManagementSystem {

    static class Student {
        int id;
        String name;
        int[] marks = new int[3];
        int total;
        float average;

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        void assignMarks(int[] m) {
            if (m.length == 3) {
                for (int i = 0; i < 3; i++) {
                    marks[i] = m[i];
                    total += m[i];
                }
                average = total / 3.0f;
            }
        }

        void displayResult() {
            System.out.println("Student ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Marks: Subject 1 = " + marks[0] + ", Subject 2 = " + marks[1] + ", Subject 3 = " + marks[2]);
            System.out.println("Total Marks: " + total);
            System.out.println("Average: " + average);
            System.out.println("Result: " + (average >= 40 ? "PASS" : "FAIL"));
            System.out.println("==================================");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        while (true) {
            System.out.println("\nStudent Management System Menu");
            System.out.println("1. Create Student");
            System.out.println("2. Assign Marks");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    students[count++] = new Student(id, name);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Student ID to assign marks: ");
                    int sid = sc.nextInt();
                    Student stu = null;
                    for (int i = 0; i < count; i++) {
                        if (students[i].id == sid) {
                            stu = students[i];
                            break;
                        }
                    }
                    if (stu != null) {
                        int[] m = new int[3];
                        System.out.print("Enter marks for Subject 1: ");
                        m[0] = sc.nextInt();
                        System.out.print("Enter marks for Subject 2: ");
                        m[1] = sc.nextInt();
                        System.out.print("Enter marks for Subject 3: ");
                        m[2] = sc.nextInt();
                        stu.assignMarks(m);
                        System.out.println("Marks assigned.");
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Student Results ---");
                    for (int i = 0; i < count; i++) {
                        students[i].displayResult();
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
