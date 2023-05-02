package com.jt;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        //    Home Screen
//    o The home screen should give the user the following options. The
//        application should continue to run until the user chooses to exit.
//        ▪ D) Add Deposit - prompt user for the deposit information and save it
//        to the csv file
//        ▪ P) Make Payment (Debit) - prompt user for the debit information
//        and save it to the csv file
//        ▪ L) Ledger - display the ledger screen
//        ▪ X) Exit - exit the application


        String commandInput;
        do {
            //Display the home screen options
            System.out.println("Welcome to your accounting ledger. Please select an option from the menu below. \n" +
                    "D) Add Deposit" + "\tP) Make a Payment" + "\tL) Display the ledger screen" + "\tX) Exit\n");

            // Accept user input
            Scanner scanner = new Scanner(System.in);
            commandInput = scanner.nextLine().toUpperCase();

            switch (commandInput) {
                case "D":
                    addDeposit(scanner);
                    break;
//                case "P":
//                    makePayment(scanner);
//                    break;
////                case "L":
////                    displayLedger();
////                    break;
////                case "X":
////                    System.out.println("Exiting the application...");
////                    break;
                default:
                    System.out.println("Sorry, the command you entered was not found. Please try again.");
            }
        } while (!commandInput.equals("X"));
    }

    public static void addDeposit(Scanner scanner) {
        System.out.println("Please enter the date (yyyy-MM-dd) of the transaction");
        String depositDate = scanner.nextLine();
        System.out.println("Please enter the time (hh:mm:ss) of the transaction");
        String depositTime = scanner.nextLine();
        System.out.println("Please enter the description of the transaction");
        String depositDescription = scanner.nextLine();
        System.out.println("Please enter the name of the vendor for the transaction");
        String depositVendor = scanner.nextLine();
        System.out.println("Please enter the deposit amount for the transaction");
        double depositAmount = Double.parseDouble(scanner.nextLine());

        try {
            FileWriter writer = new FileWriter("transactions.txt", true);
            writer.append("\n" + depositDate + "|" + depositTime + "|" + depositDescription + "|" + depositVendor +
                    "|" + depositAmount);
            System.out.println("Deposit added successfully");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while adding this deposit");
        }

    }
}

//    private static void makePayment(Scanner scanner) {
//        System.out.println("Please enter the description of the transaction you want to pay for");
//        String userDescription = scanner.nextLine();
//
//    }
//
//    private static void displayLedger() {
//        // Read transaction information from CSV file and display it on the screen
//        System.out.println("Transaction Ledger:");
//        Scanner scanner = new Scanner("transactions.txt");
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] parts = line.split("\\|");
//                String date = parts[0];
//                String time = parts[1];
//                String description = parts[2];
//                String vendor = parts[3];
//                String amount = parts[4];
//                System.out.println("This transaction entered on: " + date + " at " + time + ". It was for " + description.toLowerCase() + " from " + vendor + ". Amount: " + amount);
//            }
//        }
//    }
//
//
