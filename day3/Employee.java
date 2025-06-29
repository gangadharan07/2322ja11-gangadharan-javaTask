package day3;

import java.util.Scanner;

public class Employee {
    // Person-related fields
    private String name;
    private int age;
    private String gender;

    // Employee-related fields
    private String empId;
    private String designation;
    private double basicSalary;
    private double hra;
    private double da;
    private double deductions;

    // Input method
    public void getInput() {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter name: ");
        name = in.nextLine();

        System.out.print("Enter age: ");
        age = in.nextInt();
        in.nextLine(); // consume newline

        System.out.print("Enter gender: ");
        gender = in.nextLine();

        System.out.print("Enter employee ID: ");
        empId = in.nextLine();

        System.out.print("Enter designation: ");
        designation = in.nextLine();

        System.out.print("Enter basic salary: ");
        basicSalary = in.nextDouble();

        System.out.print("Enter HRA (House Rent Allowance): ");
        hra = in.nextDouble();

        System.out.print("Enter DA (Dearness Allowance): ");
        da = in.nextDouble();

        System.out.print("Enter deductions: ");
        deductions = in.nextDouble();
        in.close();
    }

    // Salary calculation method
    public double calculateSalary() {
        return basicSalary + hra + da - deductions;
    }

    // Display method
    public void displayInfo() {
        System.out.println("\n Employee Details:");
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Gender     : " + gender);
        System.out.println("Emp ID     : " + empId);
        System.out.println("Designation: " + designation);
        System.out.println("Basic Salary: ₹" + basicSalary);
        System.out.println("HRA         : ₹" + hra);
        System.out.println("DA          : ₹" + da);
        System.out.println("Deductions  : ₹" + deductions);
        System.out.println(" Net Salary: ₹" + calculateSalary());
    }

    // Main method
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.getInput();
        emp.displayInfo();
    }
}