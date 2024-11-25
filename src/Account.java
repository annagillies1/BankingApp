import java.util.Objects;
import java.util.Scanner;


public class Account {

    // importing the class variables
    int balance;
    int previousTransaction;
    String accountID;

    //constructor for account
    public Account(String accountID) {
        this.accountID = accountID;
        this.balance = 0;
    }

    // Getter for balance (now public)
    public int getBalance() {
        return balance;
    }

    // Getter for accountID
    public String getAccountID() {
        return accountID;
    }


    // function for depositing money
    public void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    // function for withdrawing money
    public void withdraw(int amount) {
        if (amount != 0 && amount <= balance) {
            balance = balance - amount;
            previousTransaction = -amount;
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }

    // function to show the previous transaction
    public void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("You last deposited: £" + previousTransaction + ". Your current balance is: £" + getBalance());
        } else if (previousTransaction < 0) {
            System.out.println("You last withdrew: £" + (-previousTransaction) + ". Your current balance is: £" + getBalance());
        } else {
            System.out.println("No available transactions");
        }
    }

    // interest rate calculation
    public String calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        return "The current interest rate is set to" + interestRate + "in " + years + " year;s, your balance will be £" + newBalance;
    }


};
//
