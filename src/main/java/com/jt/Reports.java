package com.jt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Reports {
    public static void main(String[] args) throws IOException {
        int reportInput;
        do {
            //Display the reports screen options
            System.out.println("""
                        Please select an option from the menu below.\s
                        
                     1) Month To Date \t2) Previous Month \t3) Year To Date \t4) Previous Year\s
                     \t5) Search by Vendor
                    \t 0) Back
                        """);

            // Accepts user input
            Scanner scanner = new Scanner(System.in);
            reportInput = scanner.nextInt();

            // Runs code segment based on user's input
            switch (reportInput) {
                case 1 -> monthToDate();
                case 2 -> previousMonth();
                case 3 -> yearToDate();
                case 4 -> previousYear();
                case 5 -> vendorSearch();
                case 0 -> Ledger.ledgerMenu();
                default -> System.out.println("Sorry, the command you entered was not found. Please try again.");
            }
        } while (!(reportInput == 0));
    }


    static LocalDateTime now = LocalDateTime.now();


    public static void monthToDate() throws IOException {

        // 1: Create a pattern for the date
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 1) Month To Date
        int currentYear = now.getYear();
        int currentMonth = now.getMonthValue();

        BufferedReader bufReader = new BufferedReader(new FileReader("transactions.txt"));
        String line = bufReader.readLine();

        while (line != null) {
            String[] splitInput = line.split(Pattern.quote("|"));
            LocalDate transactionDate = LocalDate.parse(splitInput[0], dateTimeFormatter);
            int transactionYear = transactionDate.getYear();
            int transactionMonth = transactionDate.getMonthValue();

            if (currentYear == transactionYear && currentMonth == transactionMonth) {
                System.out.println(line);
            }

            line = bufReader.readLine();
        }

        bufReader.close();
    }

    public static void previousMonth() throws IOException {

        // 1: Create a pattern for the date
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 2) Previous Month
        int currentYear = now.getYear();
        int previousMonth = (now.getMonthValue()) - 1;

        BufferedReader bufReader = new BufferedReader(new FileReader("transactions.txt"));
        String line = bufReader.readLine();

        int transactionYear = 0;
        int transactionMonth = 0;
        while (line != null) {
            String[] splitInput = line.split(Pattern.quote("|"));
            LocalDate transactionDate = LocalDate.parse(splitInput[0], dateTimeFormatter);
            transactionYear = transactionDate.getYear();
            transactionMonth = transactionDate.getMonthValue();

            if (currentYear == transactionYear && previousMonth == transactionMonth) {
                System.out.println(line);

                line = bufReader.readLine();
            }
        }
        if (currentYear == transactionYear && previousMonth == transactionMonth) {
            System.out.println("There are no transactions to display");

            bufReader.close();

        }
    }
        public static void yearToDate () throws IOException {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // 2) Previous Month
            int currentYear = now.getYear();

            BufferedReader bufReader = new BufferedReader(new FileReader("transactions.txt"));
            String line = bufReader.readLine();

            while (line != null) {
                String[] splitInput = line.split(Pattern.quote("|"));
                LocalDate transactionDate = LocalDate.parse(splitInput[0], dateTimeFormatter);
                int transactionYear = transactionDate.getYear();

                if (currentYear == transactionYear) {
                    System.out.println(line);
                }

                line = bufReader.readLine();
            }

            bufReader.close();
        }

    public static void previousYear() throws IOException {

        // 1: Create a pattern for the date
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 2) Previous Month
        int previousYear = (now.getYear()) - 1;

        BufferedReader bufReader = new BufferedReader(new FileReader("transactions.txt"));
        String line = bufReader.readLine();

        int transactionYear = 0;
        while (line != null) {
            String[] splitInput = line.split(Pattern.quote("|"));
            LocalDate transactionDate = LocalDate.parse(splitInput[0], dateTimeFormatter);
            transactionYear = transactionDate.getYear();

            if (previousYear == transactionYear) {
                System.out.println(line);
            }
            line = bufReader.readLine();
        }
        if (previousYear != transactionYear) {
            System.out.println("There are no transactions to display");
        }
        bufReader.close();
    }

    public static void vendorSearch() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the vendor you are searching for: ");
        String vendor = scanner.nextLine();
        scanner.close();

        BufferedReader bufReader = new BufferedReader(new FileReader("transactions.txt"));
        String line = bufReader.readLine();

        while (line != null) {
            if (line.toLowerCase().contains(vendor.toLowerCase())) {
                System.out.println(line);
            }
            line = bufReader.readLine();
        }
        if (!line.toLowerCase().contains(vendor.toLowerCase())) {
            System.out.println("There are no entries to display");
            bufReader.close();
        }
    }
}