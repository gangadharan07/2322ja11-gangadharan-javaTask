package day1;

import java.util.Scanner;

public class main_menu_calc {

    static int add(int a, int b) { return a + b; }
    static int sub(int a, int b) { return a - b; }
    static int mul(int a, int b) { return a * b; }
    static double div(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add 2.Sub 3.Mul 4.Div 5.Exit");
            int ch = sc.nextInt();
            if (ch == 5) break;

            System.out.print("Enter two numbers: ");
            int a = sc.nextInt(), b = sc.nextInt();

            switch (ch) {
            case 1:
                System.out.println("Result = " + add(a, b));
                break;
            case 2:
                System.out.println("Result = " + sub(a, b));
                break;
            case 3:
                System.out.println("Result = " + mul(a, b));
                break;
            case 4:
                System.out.println("Result = " + div(a, b));
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }

        }
        sc.close();
    }
}
