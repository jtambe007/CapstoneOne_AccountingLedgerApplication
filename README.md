# CapstoneOne_AccountingLedgerApplication

This project creates a CLI application that can be used to track and record financial transactions.
These transactions are read from and saved in a file called 'transactions.txt'.

## Features
The application contains a navigable home screen menu with interactive options. It also contains a submenu which has a submenu of its own.
The application allows users to add deposits, make payments and run reports with different paramenters like displaying deposits, and showing all transactions 
from the past year.

## Usage/Examples

This code block is one of many that run specific code branches based on user input. This one affects the home screen

```java
switch (commandInput) {
                case "D" -> addDeposit(scanner);
                case "P" -> makePayment(scanner);
                case "L" -> Ledger.ledgerMenu();
                case "X" -> System.out.println("Exiting the application...");
                default -> System.out.println("Sorry, the command you entered was not found. Please try again.");
            }
        } while (!commandInput.equals("X"));
```

## Development

While creating this project I learnt the importance of putting code in the right place. A few lines of code were often in the wrong place 
and this caused the code to run differently than expected. This process boosted my troubleshooting skills and pushed me to shift my thinking 
from what went wrong to what went right.
