import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookMyStayApp {


    // Centralized inventory using HashMap
    private static Map<String, Integer> roomInventory = new HashMap<>();
    private static Map<String, Double> roomPricing = new HashMap<>();

    public static void main(String[] args) {
        // Initialize inventory and pricing
        initializeInventory();

        // Use Case 4: Room Search & Availability Check
        searchAvailableRooms();
    }

    // Register room types with counts and pricing
    private static void initializeInventory() {
        roomInventory.put("Single Room", 5);
        roomInventory.put("Double Room", 3);
        roomInventory.put("Suite Room", 0); // Suite unavailable

        roomPricing.put("Single Room", 1500.0);
        roomPricing.put("Double Room", 2500.0);
        roomPricing.put("Suite Room", 5000.0);

        System.out.println("Inventory initialized successfully.\n");
    }

    // Guest initiates a search request
    private static void searchAvailableRooms() {
        System.out.println("--- Room Search Results ---");

        for (String roomType : roomInventory.keySet()) {
            int availability = roomInventory.get(roomType);
            double price = roomPricing.get(roomType);

            // Filter out unavailable rooms
            if (availability > 0) {
                System.out.println(roomType + " | Available: " + availability + " | Price: ₹" + price);
            }
        }

        System.out.println("----------------------------");
    }

}
