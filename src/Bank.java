import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bank {

    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        loadUsersFromCSV();

        // Login and show menu for Anna
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        User currentUser = findUserByName(name);
        if (currentUser == null) {
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

    private static void loadUsersFromCSV(){
        try (BufferedReader br = new BufferedReader(new FileReader("users.csv"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3){
                    User user = new User(data[0], data[1], data[2]);
                    Account account = new Account("ACC" + data[0]);
                    user.setAccounts(new ArrayList<>(List.of(account)));
                    users.add(user);
                }
            }
        } catch (IOException e){
            System.out.println("Error reading the CSV file: " + e.getMessage());
        }
    }

    private static User findUserByName(String name){
        for (User user : users){
            if (user.getName().equalsIgnoreCase(name)){
                return user;
            }
        }
    return null;
    }

    private static void showMenu(User user) {
        char option;
        Scanner scanner = new Scanner(System.in);

        List<Account> accounts = user.getAccounts();
        Account account = accounts.getFirst(); // For simplicity, using the first account

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
                    account.getTransactionHistory();
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
