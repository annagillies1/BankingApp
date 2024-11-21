import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class AccountTest {

    // testing the withdraw feature
    @Test
    void depositShouldEqualTen() {
        Account account = new Account("Test Account");
        account.deposit(10);
        assertEquals(10, account.getBalance());
    }


    // testing the withdraw feature
    @Test
    void withdrawEqualOne() {
        Account account = new Account("Test Account");
        account.deposit(10);
        account.withdraw(9);
        assertEquals(1, account.getBalance());
    }

    // testing deposit
    @Test
    void previousGetTransactionDepositTest(){
        // redirecting System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // creating an account and performing a transaction
        Account account = new Account("Test Account");
        account.deposit(10);
        account.getPreviousTransaction();
        String output = outputStream.toString().trim();
        assertEquals("Deposited: 10", output);
    }

// testing withdraw
    @Test
    void previousGetTransactionWithdrawTest(){
        // redirecting System.out to capture output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // creating an account and performing a transaction
        Account account = new Account("Test Account");
        account.deposit(50);
        account.withdraw(10);
        account.getPreviousTransaction();
        String output = outputStream.toString().trim();
        assertEquals("Withdrawn: 10", output);
    }
}

//    @org.junit.jupiter.api.Test
//    void getBalance() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void getAccountID() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void deposit() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void withdraw() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void getPreviousTransaction() {
//    }
//
//    @org.junit.jupiter.api.Test
//    void calculateInterest() {
//    }
//}