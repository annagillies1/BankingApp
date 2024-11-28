
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class AccountTest {

    // testing the withdrawal feature
    @Test
    void depositShouldEqualTen() {
        Account account = new Account("Test Account");
        account.deposit(10);
        assertEquals(10, account.getBalance());
    }


    // testing the withdrawal feature
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
        account.getTransactionHistory();
        String output = outputStream.toString().trim();
        assertEquals("You last deposited: £10. Your current balance is: £10", output);
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
        account.getTransactionHistory();
        String output = outputStream.toString().trim();
        assertEquals("You last withdrew: £10. Your current balance is: £40", output);
    }
}
