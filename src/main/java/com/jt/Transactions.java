package com.jt;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Transactions {

    public static void main(String[] args) throws IOException {
        //    Home Screen Menu
        String commandInput;
        do {
            //Display the home screen options
            System.out.println("""
                    Welcome to your accounting ledger. Please select an option from the menu below.\s
                    D) Add Deposit\tP) Make a Payment\tL) Display the ledger screen\tX) Exit
                    """);

            // Accepts user input
            Scanner scanner = new Scanner(System.in);
            commandInput = scanner.nextLine().toUpperCase();

            // Runs code segment based on user's input
            switch (commandInput) {
                case "D" -> addDeposit(scanner);
                case "P" -> makePayment(scanner);
                case "L" -> Ledger.ledgerMenu();
                case "X" -> System.out.println("Exiting the application...");
                default -> System.out.println("Sorry, the command you entered was not found. Please try again.");
            }
        } while (!commandInput.equals("X"));
    }

    public static void addDeposit(Scanner scanner) {

        // Collects user input and stores the formatted date as a string
        System.out.println("Please enter the date (yyyy-mm-dd) of the transaction");
        String depositDate = scanner.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = String.format(depositDate, fmt);

        // Collects user input and stores the formatted time as a string
        System.out.println("Please enter the time (hh:mm:ss) of the transaction");
        String depositTime = scanner.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss");
        String formattedTime = String.format(depositTime, format);

        // Collects user input and stores it as a string
        System.out.println("Please enter the description of the transaction");
        String depositDescription = scanner.nextLine();

        // Collects user input and stores it as a string
        System.out.println("Please enter the name of the vendor for the transaction");
        String depositVendor = scanner.nextLine();

        // Collects user input and stores it as a double
        System.out.println("Please enter the deposit amount for the transaction");
        double depositAmount = Double.parseDouble(scanner.nextLine());

        // Concatenates strings and writes deposit information to a file
        try {
            FileWriter writer = new FileWriter("transactions.txt", true);
            writer.append("\n").append(formattedDate).append("|").append(formattedTime).append("|").append(depositDescription).append(
                    "|").append(depositVendor).append("|$").append(String.valueOf(depositAmount));
            System.out.println("Deposit added successfully");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while adding this deposit");
        }
    }


    private static void makePayment(Scanner scanner) {
        System.out.println("Please enter the date (yyyy-mm-dd) of the transaction");
        String debitDate = scanner.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = String.format(debitDate, fmt);

        System.out.println("Please enter the time (hh:mm:ss) of the transaction");
        String debitTime = scanner.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss");
        String formattedTime = String.format(debitTime, format);

        System.out.println("Please enter the description of the transaction");
        String debitDescription = scanner.nextLine();

        System.out.println("Please enter the name of the vendor for the transaction");
        String debitVendor = scanner.nextLine();

        System.out.println("Please enter the debit amount for the transaction");
        double debitAmount = Double.parseDouble(scanner.nextLine());

        try {
            FileWriter writer = new FileWriter("transactions.txt", true);
            writer.append("\n").append(formattedDate).append("|").append(formattedTime).append("|").append(debitDescription).append("|").append(debitVendor).append("|-$").append(String.valueOf(debitAmount));
            System.out.println("Deposit added successfully");
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while adding this deposit");
        }
    }
    }

