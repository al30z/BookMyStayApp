
import java.util.LinkedList;
import java.util.Queue;

public class BookMyStayApp {

    // Booking Request Queue
    private static Queue<Reservation> bookingQueue = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println("=== Use Case 5: Booking Request Queue ===");

        // Guest submits booking requests
        submitBookingRequest(new Reservation("Alice", "Single Room"));
        submitBookingRequest(new Reservation("Bob", "Double Room"));
        submitBookingRequest(new Reservation("Charlie", "Suite Room"));

        // Display queued requests
        displayBookingQueue();
    }

    // Submit a booking request (added to queue)
    private static void submitBookingRequest(Reservation reservation) {
        bookingQueue.add(reservation);
        System.out.println("Booking request submitted: " + reservation);
    }

    // Display current queue state
    private static void displayBookingQueue() {
        System.out.println("\n--- Current Booking Request Queue ---");
        for (Reservation r : bookingQueue) {
            System.out.println(r);
        }
        System.out.println("-------------------------------------");
    }
}

// Reservation class to represent guest intent
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + " | Room Type: " + roomType;
    }
}