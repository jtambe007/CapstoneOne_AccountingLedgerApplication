package com.jt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {



    public static void ledgerMenu() throws IOException {
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
                    allEntries();
                    break;
                case "D":
                    displayDeposits();
                    break;
                case "P":
                    displayPayments();
                    break;
                case "R":
                    Reports.main(null);
                    break;
                case "H":
                  returnHome();
                    break;
                default:
                    System.out.println("Sorry, the command you entered was not found. Please try again.");
            }
        } while (!ledgerInput.equals("H"));
    }


    private static void allEntries() throws IOException {
        // Read transaction information from CSV file and display it on the screen
        System.out.println("Transaction Ledger:");
        FileReader fileReader = new FileReader("transactions.txt");
        BufferedReader bufReader = new BufferedReader(fileReader);
        String input = bufReader.readLine();
        while (input != null) {
            System.out.println(input);
        }
        bufReader.close();
    }


    private static void displayPayments() throws IOException {
        // Read transaction information from CSV file and display it on the screen
        System.out.println("Payments Ledger:");
        BufferedReader bufReader = new BufferedReader(new FileReader("transactions.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            line = bufReader.readLine();
            for (String element : listOfLines) {
                if (element.contains("-$")) {
                    System.out.println(element);
                }
            }
        }
        bufReader.close();
    }

    private static void displayDeposits() throws IOException {
        // Read transaction information from CSV file and display it on the screen
        System.out.println("Deposits Ledger:");
        BufferedReader bufReader = new BufferedReader(new FileReader("transactions.txt"));
        ArrayList<String> listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            line = bufReader.readLine();
            for (String element : listOfLines) {
                if (!element.contains("-$")) {
                    System.out.println(element);
                }
            }
        }
        bufReader.close();
    }

    public static void returnHome() throws IOException {
        System.out.println("Returning to main menu...");
        Transactions.main(null);
    }
}

