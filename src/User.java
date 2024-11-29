import java.util.List;

public class User {

    private String accountID;
    private String name;
    private String password;
    private boolean loggedIn;
    private List<Account> accounts; // if a user can have multiple accounts

    // setting up the constructor
    public User (String accountID, String name, String password){
        this.accountID = accountID;
        this.name = name;
        this.password = password;
        this.loggedIn = false;
    }
    // Getters and Setters
    public String getCustomerID() {
        return accountID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    // setting up the log in feature
    public void login(String inputPassword){
        if (inputPassword.equals(this.password)) {
            this.loggedIn = true;
            System.out.println("User " + this.accountID + " " + this.name + " is logged in");
        } else {
            throw new IllegalArgumentException("Incorrect password");
        }
    }
}
