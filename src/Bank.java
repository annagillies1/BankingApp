import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

    public static void main(String[] args) {
        // Create users and their accounts
        User anna = new User("A0001", "Anna", "1234");
        Account annaSavings = new Account("SAV001");
        anna.setAccounts(new ArrayList<>(List.of(annaSavings)));

        User mark = new User("A0002", "Mark", "2345");
        Account markSavings = new Account("SAV002");
        mark.setAccounts(new ArrayList<>(List.of(markSavings)));

        // Login and show menu for Anna
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        User currentUser;
        if (name.equalsIgnoreCase("Anna")) {
            currentUser = anna;
        } else if (name.equalsIgnoreCase("Mark")) {
            currentUser = mark;
        } else {
            System.out.println("No user found with the name: " + name);
            return; // Exit the program
        }

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        try {
            currentUser.login(password);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return; // Exit the program
        }

        // Show menu for the logged-in user
        showMenu(currentUser);
    }

    private static void showMenu(User user) {
        char option;
        Scanner scanner = new Scanner(System.in);

        List<Account> accounts = user.getAccounts();
        Account account = accounts.get(0); // For simplicity, using the first account

        System.out.println("Welcome, " + user.getName());
        System.out.println("Your ID is: " + user.getCustomerID());
        System.out.println("What would you like to do?");
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Change user");
        System.out.println("G. Exit");

        do {
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);

            switch (option) {
                case 'A':
                    System.out.println("Your balance is: " + account.getBalance());
                    break;
                case 'B':
                    System.out.println("Enter deposit amount: ");
                    int deposit = scanner.nextInt();
                    account.deposit(deposit);
                    System.out.println("You have successfully deposited £" + deposit + ". Your new balance is £" + account.getBalance() +".");
                    break;
                case 'C':
                    System.out.println("Enter withdrawal amount: ");
                    int withdrawal = scanner.nextInt();
                    account.withdraw(withdrawal);
                    System.out.println("You have successfully withdrawn £" + withdrawal + ". Your new balance is £" + account.getBalance() +".");
                    break;
                case 'D':
                    account.getPreviousTransaction();
                    break;
                case 'E':
                    System.out.println("Enter the number of years for interest calculation: ");
                    int years = scanner.nextInt();
                    account.calculateInterest(years);
                    break;
                case 'F':
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 'F');
    }
}
