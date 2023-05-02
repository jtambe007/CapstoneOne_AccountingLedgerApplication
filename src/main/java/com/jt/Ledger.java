package com.jt;

import java.util.Scanner;

public class Ledger {
    public static void main(String[] args) {
        //    Home Screen Menu
        String ledgerInput;
        do {
            //Display the ledger screen options
            System.out.println("""
                    Please select an option from the menu below.\s
                    A) Display all entries\tD) Display deposits into the account\tP) Display pending payments\tR) Display reports\tH) Return to home page
                    """);

            // Accepts user input
            Scanner scanner = new Scanner(System.in);
            ledgerInput = scanner.nextLine().toUpperCase();

            // Runs code segment based on user's input
            switch (ledgerInput) {
                case "A":
                    allEntries(scanner);
                    break;
                case "D":

                    break;
                case "P":
//                    Ledger();
                    break;
                case "R":
                    break;
                case "H":

                    break;
                default:
                    System.out.println("Sorry, the command you entered was not found. Please try again.");
            }
        } while (!ledgerInput.equals("H"));
    }


    private static void allEntries(Scanner scanner) {
        // Read transaction information from CSV file and display it on the screen
        System.out.println("Transaction Ledger:");
         scanner = new Scanner("transactions.txt");
            while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\|");
            String date = parts[0];
            String time = parts[1];
            String description = parts[2];
            String vendor = parts[3];
            String amount = parts[4];
            System.out.println("This transaction entered on: " + date + " at " + time + ". It was for " + description.toLowerCase() + " from " + vendor + ". Amount: " + amount);
        }
    }

    private static void displayPayments(){

    }
}
