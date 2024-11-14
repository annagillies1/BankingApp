import java.util.Scanner;


public class Account {

    // importing the class variables
    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    // setting up the class constructor
    Account(String cusName, String cusID) {
        this.customerName = cusName;
        this.customerID = cusID;
    }

    // function for depositing money
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    // function for withdrawing money
    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    // function to show the previous amount
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + previousTransaction);
        } else {
            System.out.println("No available transactions");
        }
    }

    // interest rate calculation
    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is set to " + interestRate);
        System.out.println("In " + " years, your balance will be " + newBalance);
    }

    // show menu function
    void showMenu() {
        char option;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is: " + customerID);
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate Interest");
        System.out.println("F. Exit");

        // in a do while loop
        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                // checking the account balance
                case 'A':
                    System.out.println("\uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄");
                    System.out.println("Your balance is: £" + balance);
                    System.out.println("\uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄");
                    break;

                case 'B':
                    System.out.println("Enter a deposit amount");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    System.out.println("Your new balance is: " + balance);
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("Your new balance is: " + balance);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println("\uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄");
                    getPreviousTransaction();
                    System.out.println("\uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄ \uD83C\uDF84 ❄");
                    break;
                case 'E':
                    System.out.println("Enter the years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("\uD83C\uDF84 ❄");
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Please enter a valid option");
                    break;
            }
        } while(option!='F');
        System.out.println("Thank you for banking with us!");
    }
}
