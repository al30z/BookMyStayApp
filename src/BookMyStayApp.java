import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookMyStayApp {

    // Centralized inventory using HashMap
    private static Map<String, Integer> roomInventory = new HashMap<>();

    public static void main(String[] args) {
        // Initialize inventory component
        initializeInventory();

        // Display current inventory state
        displayInventory();

        // Example: Update availability
        updateAvailability("Single Room", -1); // One single room booked
        updateAvailability("Suite Room", +1);  // One suite room freed

        // Display updated inventory state
        displayInventory();
    }

    // Register room types with their counts
    private static void initializeInventory() {
        roomInventory.put("Single Room", 5);
        roomInventory.put("Double Room", 3);
        roomInventory.put("Suite Room", 2);
        System.out.println("Inventory initialized successfully.\n");
    }

    // Controlled method to update availability
    private static void updateAvailability(String roomType, int change) {
        if (roomInventory.containsKey(roomType)) {
            int current = roomInventory.get(roomType);
            int updated = current + change;
            if (updated < 0) {
                System.out.println("Error: Not enough " + roomType + " available to update.");
            } else {
                roomInventory.put(roomType, updated);
                System.out.println("Updated " + roomType + " availability to " + updated);
            }
        } else {
            System.out.println("Error: Room type not found in inventory.");
        }
    }

    // Display current inventory state
    private static void displayInventory() {
        System.out.println("--- Current Room Inventory ---");
        for (Map.Entry<String, Integer> entry : roomInventory.entrySet()) {
            System.out.println(entry.getKey() + " - Available: " + entry.getValue());
        }
        System.out.println("-------------------------------\n");
    }
}
