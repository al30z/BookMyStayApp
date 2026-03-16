
import java.util.*;

public class BookMyStayApp {

    // Centralized inventory
    private static Map<String, Integer> roomInventory = new HashMap<>();
    private static Map<String, Double> roomPricing = new HashMap<>();

    // Booking Request Queue
    private static Queue<Reservation> bookingQueue = new LinkedList<>();

    // Track allocated room IDs to prevent reuse
    private static Set<String> allocatedRoomIds = new HashSet<>();

    public static void main(String[] args) {
        // Initialize inventory and pricing
        initializeInventory();

        // Submit some booking requests
        submitBookingRequest(new Reservation("Alice", "Single Room"));
        submitBookingRequest(new Reservation("Bob", "Double Room"));
        submitBookingRequest(new Reservation("Charlie", "Suite Room"));
        submitBookingRequest(new Reservation("Diana", "Suite Room"));

        // Process queued requests
        processBookingRequests();
    }

    private static void initializeInventory() {
        roomInventory.put("Single Room", 2);
        roomInventory.put("Double Room", 1);
        roomInventory.put("Suite Room", 1);

        roomPricing.put("Single Room", 1500.0);
        roomPricing.put("Double Room", 2500.0);
        roomPricing.put("Suite Room", 5000.0);

        System.out.println("Inventory initialized successfully.\n");
    }

    // Submit booking request
    private static void submitBookingRequest(Reservation reservation) {
        bookingQueue.add(reservation);
        System.out.println("Booking request submitted: " + reservation);
    }

    // Booking Service: process queued requests
    private static void processBookingRequests() {
        System.out.println("\n=== Processing Booking Requests ===");

        while (!bookingQueue.isEmpty()) {
            Reservation request = bookingQueue.poll(); // dequeue
            String roomType = request.getRoomType();

            // Check availability
            int availability = roomInventory.getOrDefault(roomType, 0);
            if (availability > 0) {
                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Decrement inventory
                roomInventory.put(roomType, availability - 1);

                // Confirm reservation
                System.out.println("Reservation confirmed for " + request.getGuestName() +
                        " | Room Type: " + roomType +
                        " | Room ID: " + roomId +
                        " | Price: ₹" + roomPricing.get(roomType));
            } else {
                System.out.println("Reservation failed for " + request.getGuestName() +
                        " | Room Type: " + roomType +
                        " | Reason: No availability.");
            }
        }

        System.out.println("=== All requests processed ===");
    }

    // Generate unique room ID
    private static String generateRoomId(String roomType) {
        String prefix = roomType.replaceAll("\\s+", "").substring(0, 3).toUpperCase();
        String roomId;
        do {
            roomId = prefix + "-" + UUID.randomUUID().toString().substring(0, 5);
        } while (allocatedRoomIds.contains(roomId));

        allocatedRoomIds.add(roomId);
        return roomId;
    }
}

// Reservation class
class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + " | Room Type: " + roomType;
    }
}