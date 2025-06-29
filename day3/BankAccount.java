package day3;

import java.util.Scanner;

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✅ Deposited ₹" + amount);
        } else {
            System.out.println("❌ Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("✅ Withdrawn ₹" + amount);
        } else {
            System.out.println("❌ Insufficient balance or invalid amount.");
        }
    }

    // Display account information
    public void displayInfo() {
        System.out.println("\n🔐 Account Information:");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Get account details from user
        System.out.print("Enter account holder name: ");
        String name = in.nextLine();

        System.out.print("Enter account number: ");
        String accNo = in.nextLine();

        System.out.print("Enter initial balance: ");
        double initialBalance = in.nextDouble();
        in.nextLine(); // clear newline

        // Create account
        BankAccount account = new BankAccount(name, accNo, initialBalance);

        int choice;
        do {
            System.out.println("\n🏦 Bank Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Account Info");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmt = in.nextDouble();
                    account.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmt = in.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 3:
                    account.displayInfo();
                    break;
                case 4:
                    System.out.println("Thank you! Exiting.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        in.close();
    }
    }
