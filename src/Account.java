import java.util.ArrayList;
import java.util.List;

public class Account {

    // importing the class variables
    int balance;
    List<String> transactionHistory;
    String accountID;

    //constructor for account
    public Account(String accountID) {
        this.accountID = accountID;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
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
            transactionHistory.add("Deposited £" + amount + ". Balance: £" + balance);
        }
    }

    // function for withdrawing money
    public void withdraw(int amount) {
        if (amount != 0 && amount <= balance) {
            balance = balance - amount;
            transactionHistory.add("You last withdrew £" + amount + ". Your current balance is: £" + balance);
        } else {
            transactionHistory.add("Failed withdrawal attempt of £" + amount + ". Balance: £" + balance);
        }
    }

    // function to show the previous transaction
    public String getTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            return "No transactions available.";
        }
        StringBuilder history = new StringBuilder();
        for (String transaction : transactionHistory) {
            history.append(transaction).append("\n");
        }
        return history.toString();
    }


    // interest rate calculation
    public String calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        return "The current interest rate is set to " + interestRate + ". in " + years + " years, your balance will be £" + newBalance;
    }


};
//
