public class HotelBookingApp {
    public static void main(String[] args) {
        // Use Case 1: Application Entry & Welcome Message
        displayWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();

        System.out.println("Navigating to main menu...");
        // Placeholder for next use cases
        scanner.close();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=======================================");
        System.out.println("   Welcome to The Hotel Management System");
        System.out.println("=======================================");
        System.out.println("System initialised successfully.");
    }

}
