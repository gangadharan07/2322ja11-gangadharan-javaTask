package day5;

import java.io.*;
import java.util.*;

public class Post_StudentManagementApp {
    static ArrayList<String> studentNames = new ArrayList<>();
    static HashMap<String, ArrayList<String>> studentCourses = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Student Management App ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course to Student");
            System.out.println("3. Search Student & Courses");
            System.out.println("4. Delete Student");
            System.out.println("5. Delete Course from Student");
            System.out.println("6. Save Course List to File");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: addCourse(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5: deleteCourse(); break;
                case 6: saveToFile(); break;
                case 7: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        if (studentCourses.containsKey(id)) {
            System.out.println("Student ID already exists.");
            return;
        }
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        studentNames.add(name);
        studentCourses.put(id, new ArrayList<>());
        System.out.println("Student added.");
    }

    static void addCourse() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        if (!studentCourses.containsKey(id)) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();
        studentCourses.get(id).add(course);
        System.out.println("Course added.");
    }

    static void searchStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        if (studentCourses.containsKey(id)) {
            System.out.println("Courses for student ID " + id + ":");
            ArrayList<String> courses = studentCourses.get(id);
            if (courses.isEmpty()) {
                System.out.println("  No courses enrolled.");
            } else {
                for (String c : courses) {
                    System.out.println("  - " + c);
                }
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();
        if (studentCourses.remove(id) != null) {
            System.out.println("Student and all their courses deleted.");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    static void deleteCourse() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        if (!studentCourses.containsKey(id)) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter Course to delete: ");
        String course = sc.nextLine();
        if (studentCourses.get(id).remove(course)) {
            System.out.println("Course removed.");
        } else {
            System.out.println("Course not found.");
        }
    }

    static void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("CourseList.txt"));
            for (String id : studentCourses.keySet()) {
                writer.write("Student ID: " + id + "\n");
                for (String course : studentCourses.get(id)) {
                    writer.write("  - " + course + "\n");
                }
                writer.newLine();
            }
            writer.close();
            System.out.println("Course list saved to CourseList.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }
}
