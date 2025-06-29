package day1;

import java.util.Scanner;

public class simple_int_calc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal: ");
        float principal = sc.nextFloat();

        System.out.print("Enter Rate of Interest: ");
        float rate = sc.nextFloat();

        System.out.print("Enter Time (in years): ");
        float time = sc.nextFloat();

        if (principal > 0 && rate > 0 && time > 0) {
            float si = (principal * rate * time) / 100;
            System.out.println("Simple Interest = " + si);
        } else {
            System.out.println("Invalid input! All values must be greater than zero.");
        }
        sc.close();
    }
}
