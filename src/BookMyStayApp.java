public class BookMyStayApp {
    public static void main(String[] args) {
        // Use Case 2: Basic Room Types & Static Availability
        displayRoomTypes();
    }

    private static void displayRoomTypes() {
        System.out.println("\n--- Available Room Types ---");

        // Availability stored in simple variables
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability  = 2;

        // Printing room details
        System.out.println("Single Room - Available: " + singleRoomAvailability);
        System.out.println("Double Room - Available: " + doubleRoomAvailability);
        System.out.println("Suite Room  - Available: " + suiteRoomAvailability);

        System.out.println("-----------------------------");
    }
    
}
