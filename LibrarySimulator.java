/*
 * https://github.com/faris-stat/CSC-111-Phase2
 * Project2: Library Simulation 2 (CSC 111)
 * Group Members:
 * 1. Faris Abdulwahab Alatallah - 445102435
 */
import java.util.Scanner;

public class LibrarySimulator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Predefined members
        Member user1 = new Member(1001, "Faris Abdulwahab", 0);
        Member user2 = new Member(1002, "Abdullah Abdulaziz", 0);
        Member user3 = new Member(1003, "Raed Sultan", 0);

        boolean running = true;

        while (running) {
         // Main menu for picking member or admin
            System.out.println("\n========== Library Simulation ==========");
            System.out.println("Select option:"); 
            System.out.println("1. Login as " + user1.getName());
            System.out.println("2. Login as " + user2.getName());
            System.out.println("3. Login as " + user3.getName());
            System.out.println("4. Login as Administrator");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline 

            
            if (choice >= 1 && choice <= 3) {
              // pick the current member
                Member current;
                if (choice == 1) current = user1;
                else if (choice == 2) current = user2;
                else current = user3;

                // reset session counters each login
                current.reset();

                boolean sessionActive = true;

                while (sessionActive) {
                    System.out.println("\n--- Welcome, " + current.getName() + " ---");
                    System.out.println("1. View Borrowed Books");
                    System.out.println("2. Borrow Book");
                    System.out.println("3. Return Book");
                    System.out.println("4. View Session Summary");
                    System.out.println("5. Exit to Main Menu");
                    System.out.print("Enter choice: ");

                    int op = scanner.nextInt();
                    scanner.nextLine();
                    // do the selected action
                    switch (op) {
                        case 1:
                            current.viewBorrowedCount();
                            break;
                        case 2:
                            current.borrowOne();
                            break;
                        case 3:
                            current.returnOne();
                            break;
                        case 4:
                            current.displayStatistics();
                            break;
                        case 5:
                            System.out.println("Session ended. Books now: " + current.getBorrowedCount());
                            sessionActive = false;
                            break;
                        default:
                            System.out.println("Invalid option."); 
                    }
                }

            
            } else if (choice == 4) {
                // admin login
               System.out.print("Enter admin password: ");  
                String password = scanner.nextLine();  
  
                if (!password.equals("admin")) {  
                    System.out.println("Invalid password. Access denied.");  
                } else {  
                    boolean adminActive = true;
                    System.out.println("\n--- Admin Menu ---");

                    while (adminActive) {
                         // admin options
                        System.out.println("1. View Total Revenue");
                        System.out.println("2. View Most Frequent Operation"); 
                        System.out.println("3. Exit Admin");
                        System.out.print("Enter choice: ");

                        int adminChoice = scanner.nextInt();
                        scanner.nextLine(); 

                        if (adminChoice == 1) {
                            System.out.printf("Total Revenue: %.2f\n", Member.TotalRevenue);

                        } else if (adminChoice == 2) {
                            System.out.println("Total Borrows: " + Member.TotalBorrows);
                            System.out.println("Total Returns: " + Member.TotalReturns);
                            
                            if (Member.TotalBorrows > Member.TotalReturns) 
                                System.out.println("Most frequent: Borrowing");
                            else if (Member.TotalReturns > Member.TotalBorrows) 
                                System.out.println("Most frequent: Returning");
                            else 
                                System.out.println("Most frequent: Equal (Tie)");

                        } else if (adminChoice == 3) {
                            adminActive = false; // exit admin menu
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                } 
            } else if (choice == 5) {
              // exit program and show global stats
                System.out.println("Exiting program...");
                running = false;

                System.out.println("\n=== Global Statistics ===");
                System.out.printf("Total Revenue: %.2f\n", Member.TotalRevenue);
                System.out.println("Total Borrows: " + Member.TotalBorrows);
                System.out.println("Total Returns: " + Member.TotalReturns);
                System.out.println("Total View Borrowed Count: " + Member.TotalViewBorrowed);

            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}
