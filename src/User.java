import java.util.List;

public class User {

    private String customerID;
    private String name;
    private String password;
    private boolean loggedIn;
    private List<Account> accounts; // if a user can have multiple accounts

    // setting up the constructor
    public User (String customerID, String name, String password){
        this.customerID = customerID;
        this.name = name;
        this.password = password;
        this.loggedIn = false;
    }

    // setting up the log in feature
    public void login(String inputPassword){
        if (inputPassword.equals(this.password)) {
            this.loggedIn = true;
            System.out.println("User " + this.customerID + " " + this.name + " is logged in");
        } else {
            throw new IllegalArgumentException("Incorrect password");
        }
    }

    public boolean isLoggedIn() {
        return this.loggedIn;
    }

    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;
    }

    public List<Account> getAccounts(){
        return accounts;
    }

    public String getName(){
        return name;
    }

    public String getCustomerID() {
        return customerID;
    }
}
