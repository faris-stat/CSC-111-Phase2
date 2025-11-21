import java.util.Scanner;

public class LibrarySimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Member user1 = new Member(1001, "Faris Abdulwahab", 0);
        Member user2 = new Member(1002, "Abdullah Abdulaziz", 0);
        Member user3 = new Member(1003, "Raed Sultan", 0);

        boolean running = true;

        //  Main Loop 
        while (running) {
            System.out.println("\n========== Welcome to the Library Simulation ==========");
            System.out.println("Select an option:");
            System.out.println("1. Login as " + user1.getName());
            System.out.println("2. Login as " + user2.getName());
            System.out.println("3. Login as " + user3.getName());
            System.out.println("4. Login as Administrator");
            System.out.println("5. Exit Program");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice >= 1 && choice <= 3) {
                System.out.println(">> User login successful. (Features coming in next update)");
                //
            } else if (choice == 4) {
                System.out.println(">> Admin Section. (Under Construction)");
                //
            } else if (choice == 5) {
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}

