package day5;

import java.util.*;

public class Main_StudentCourseEnrollment {

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        HashMap<String, ArrayList<String>> enrollmentMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Course Enrollment System:");
            System.out.println("1. Add Student");
            System.out.println("2. Enroll Course for Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Display Students and Courses");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name to add: ");
                    String name = sc.nextLine().trim();
                    if (!students.contains(name)) {
                        students.add(name);
                        enrollmentMap.put(name, new ArrayList<>());
                        System.out.println("Student added.");
                    } else {
                        System.out.println("Student already exists.");
                    }
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String studentName = sc.nextLine().trim();
                    if (students.contains(studentName)) {
                        System.out.print("Enter course to enroll: ");
                        String course = sc.nextLine().trim();
                        ArrayList<String> courses = enrollmentMap.get(studentName);
                        if (!courses.contains(course)) {
                            courses.add(course);
                            System.out.println("Course enrolled.");
                        } else {
                            System.out.println("Course already enrolled.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student name to remove: ");
                    String removeName = sc.nextLine().trim();
                    if (students.remove(removeName)) {
                        enrollmentMap.remove(removeName);
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("\nStudents and Enrolled Courses:");
                    Iterator<String> studentIterator = students.iterator();
                    while (studentIterator.hasNext()) {
                        String s = studentIterator.next();
                        System.out.println("- " + s + ":");
                        ArrayList<String> courses = enrollmentMap.get(s);
                        if (courses.isEmpty()) {
                            System.out.println("  No courses enrolled.");
                        } else {
                            Iterator<String> courseIterator = courses.iterator();
                            while (courseIterator.hasNext()) {
                                System.out.println("  • " + courseIterator.next());
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting system.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
