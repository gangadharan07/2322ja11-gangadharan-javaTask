package day5;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentListExample {

    // Inner class to represent a Student
    static class Student {
        int id;
        String name;
        int age;

        Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        void display() {
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
        }
    }

    public static void main(String[] args) {
        // Create an ArrayList of Student objects
        ArrayList<Student> students = new ArrayList<>();

        // Add sample students
        students.add(new Student(101, "John", 20));
        students.add(new Student(102, "Alice", 21));
        students.add(new Student(103, "Bob", 19));

        // Use Iterator to display student details
        System.out.println("Student List:");
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            s.display();
        }
    }
}
