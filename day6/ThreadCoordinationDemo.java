package day6;

public class ThreadCoordinationDemo {

    static class TaskThread extends Thread {
        private String name;

        public TaskThread(String name) {
            this.name = name;
        }

        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(name + " → Count: " + i);
                try {
                    Thread.sleep(500); // pause for 0.5 seconds
                } catch (InterruptedException e) {
                    System.out.println(name + " interrupted.");
                }
            }
            System.out.println(name + " finished.");
        }
    }

    public static void main(String[] args) {
        TaskThread t1 = new TaskThread("Thread-A");
        TaskThread t2 = new TaskThread("Thread-B");

        t1.start();

        try {
            // Main thread waits until t1 finishes
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for t1.");
        }

        t2.start(); // Starts only after t1 completes

        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting for t2.");
        }

        System.out.println("Main thread finished.");
    }
}
