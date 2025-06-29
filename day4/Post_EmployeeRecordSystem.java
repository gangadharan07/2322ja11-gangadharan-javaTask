package day4;
import java.io.*;
import java.util.*;

public class Post_EmployeeRecordSystem {
    static final String FILE_NAME = "employees.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Record System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addEmployee(sc);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee(sc);
                    break;
                case 4:
                    deleteEmployee(sc);
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void addEmployee(Scanner sc) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
            System.out.print("Enter Employee ID: ");
            String id = sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Role: ");
            String role = sc.nextLine();
            System.out.print("Enter Salary: ");
            String salary = sc.nextLine();

            String record = id + "," + name + "," + role + "," + salary;
            writer.write(record);
            writer.newLine();
            writer.close();
            System.out.println("Employee added successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    static void viewEmployees() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            System.out.println("\nEmployee Records:");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    System.out.println("ID: " + parts[0] + ", Name: " + parts[1] + ", Role: " + parts[2] + ", Salary: " + parts[3]);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
    }

    static void updateEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to update: ");
        String idToUpdate = sc.nextLine();
        List<String> lines = new ArrayList<>();
        boolean updated = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(idToUpdate)) {
                    System.out.print("Enter New Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter New Role: ");
                    String role = sc.nextLine();
                    System.out.print("Enter New Salary: ");
                    String salary = sc.nextLine();
                    lines.add(idToUpdate + "," + name + "," + role + "," + salary);
                    updated = true;
                } else {
                    lines.add(line);
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();

            if (updated) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee ID not found.");
            }
        } catch (IOException e) {
            System.out.println("Error updating file.");
        }
    }

    static void deleteEmployee(Scanner sc) {
        System.out.print("Enter Employee ID to delete: ");
        String idToDelete = sc.nextLine();
        List<String> lines = new ArrayList<>();
        boolean deleted = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[0].equals(idToDelete)) {
                    lines.add(line);
                } else {
                    deleted = true;
                }
            }
            reader.close();

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
            writer.close();

            if (deleted) {
                System.out.println("Employee deleted successfully.");
            } else {
                System.out.println("Employee ID not found.");
            }
        } catch (IOException e) {
            System.out.println("Error deleting from file.");
        }
    }
}
