package day6;

public class NumberPrinterThread extends Thread {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(500); // optional delay for visibility
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        NumberPrinterThread t = new NumberPrinterThread();
        t.start(); // start the thread
    }
}
