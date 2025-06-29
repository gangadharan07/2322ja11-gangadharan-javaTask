package day6;

public class BankingApp {
    private int balance = 1000; // Initial account balance

    // Synchronized method to withdraw money
    public synchronized void withdraw(String user, int amount) {
        System.out.println(user + " is attempting to withdraw ₹" + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(1000); // Simulate processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println("[" + Thread.currentThread().getName() + "] ₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("[" + Thread.currentThread().getName() + "] Insufficient balance for ₹" + amount + " withdrawal.");
        }

        System.out.println("[" + Thread.currentThread().getName() + "] Remaining Balance: ₹" + balance);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        BankingApp account = new BankingApp();

        // Create multiple user threads
        Thread user1 = new Thread(() -> account.withdraw("User1", 700), "User1");
        Thread user2 = new Thread(() -> account.withdraw("User2", 400), "User2");
        Thread user3 = new Thread(() -> account.withdraw("User3", 300), "User3");

        // Start all threads
        user1.start();
        user2.start();
        user3.start();
    }
}
