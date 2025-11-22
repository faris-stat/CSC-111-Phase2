/*
 * https://github.com/faris-stat/CSC-111-Phase2
 * Project 2: Members Library Simulation (CSC 111)
 * Group Members:
 * 1. Faris Abdulwahab Alatallah - 445102435
 */
// Library member class: tracks info and what they do in a session
public class Member {

    private int id;
    private String name;
    private int borrowedCount;

  // Stats for this session only
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    // Stats for all members
    public static double TotalRevenue = 0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;

    // Constructor
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;

      
        numViewBorrowed = 0;
        numBorrows = 0;
        numReturns = 0;
        sessionFees = 0;
    }
// Check if they can borrow more (max 5)
private boolean canBorrow() {  
        return borrowedCount < 5;   
    }  
  // Check if they can return a book (need at least 1)
    private boolean canReturn() {  
        return borrowedCount > 0;   
    }  
  
  
    public void viewBorrowedCount() {  
        numViewBorrowed++;  
        TotalViewBorrowed++;  
        System.out.println("Books currently borrowed: " + borrowedCount);  
    }  
   // Borrow a book, update stats and fees
    public boolean borrowOne() {  
        if (!canBorrow()) {  
            System.out.println("You cannot borrow more than 5 books.");  
            return false;  
        }  
        borrowedCount++;  
        numBorrows++;  
        TotalBorrows++;  
        sessionFees += 0.50;  
        TotalRevenue += 0.50;  
        System.out.printf("Book borrowed successfully. Fee: %.2f\n", 0.50);  
        return true;  
    }  
  
      // Return a book, update stats
    public boolean returnOne() {  
        if (!canReturn()) {  
            System.out.println("You have no books to return.");  
            return false;  
        }  
        borrowedCount--;  
        numReturns++;  
        TotalReturns++;  
        System.out.println("Book returned successfully.");  
        return true;  
    }  
  
      // Show stats for this session
    public void displayStatistics() {  
        System.out.println("====== Session Summary for " + name + " (ID: " + id + ") ======");  
        System.out.println("Books Borrowed (this session): " + numBorrows);  
        System.out.println("Books Returned (this session): " + numReturns);  
        System.out.println("Times View Borrowed Count used (this session): " + numViewBorrowed);  
        System.out.printf("Fees Incurred (this session): %.2f\n", sessionFees);  
    }  
  
    
    public void reset() {  
        this.numViewBorrowed = 0;  
        this.numBorrows = 0;  
        this.numReturns = 0;  
        this.sessionFees = 0.0;  
    }  
  
    // Getters and setter
    public int getId() {  
        return id;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public int getBorrowedCount() {  
        return borrowedCount;  
    }  
  
    public double getSessionFees() {  
        return sessionFees;  
    }  
  

    public void setBorrowedCount(int borrowedCount) {  
        this.borrowedCount = borrowedCount;  
    }  
}  
