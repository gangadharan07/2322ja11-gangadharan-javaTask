package day6;
public class MultiThreadMessage implements Runnable {

    private String message;

    public MultiThreadMessage(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " → " + message + " (" + i + ")");
            try {
                Thread.sleep(500); // optional delay for readability
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadMessage task1 = new MultiThreadMessage("Hello from Thread 1");
        MultiThreadMessage task2 = new MultiThreadMessage("Hello from Thread 2");

        Thread t1 = new Thread(task1, "Thread-1");
        Thread t2 = new Thread(task2, "Thread-2");

        t1.start();
        t2.start();
    }
}
 