package day6;
public class TicketBookingSimulation {

    // Total available seats (shared resource)
    private int availableSeats = 5;

    // Method for booking tickets (synchronized to prevent race conditions)
    public void bookTicket(String user, int requestedSeats) {
        synchronized (this) {
            System.out.println(user + " is trying to book " + requestedSeats + " seat(s)...");

            if (requestedSeats <= availableSeats) {
                System.out.println("Booking in progress for " + user + "...");
                try {
                    Thread.sleep(1000); // Simulate delay
                } catch (InterruptedException e) {
                    System.out.println("Booking interrupted.");
                }

                availableSeats -= requestedSeats;
                System.out.println("✅ " + user + " booked " + requestedSeats + " seat(s).");
                System.out.println("🎫 Remaining Seats: " + availableSeats);
            } else {
                System.out.println("❌ Not enough seats for " + user + ". Booking failed.");
                System.out.println("🎫 Remaining Seats: " + availableSeats);
            }
        }
    }

    // Inner class representing a user thread
    static class UserThread extends Thread {
        TicketBookingSimulation bookingSystem;
        String userName;
        int seatsToBook;

        UserThread(TicketBookingSimulation system, String name, int seats) {
            this.bookingSystem = system;
            this.userName = name;
            this.seatsToBook = seats;
        }

        public void run() {
            bookingSystem.bookTicket(userName, seatsToBook);
        }
    }

    public static void main(String[] args) {
        TicketBookingSimulation system = new TicketBookingSimulation();

        // Create user threads
        UserThread user1 = new UserThread(system, "Alice", 2);
        UserThread user2 = new UserThread(system, "Bob", 1);
        UserThread user3 = new UserThread(system, "Charlie", 3);
        UserThread user4 = new UserThread(system, "Diana", 1);

        // Start booking attempts
        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
