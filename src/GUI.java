import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GUI implements ActionListener {

    private static List<User> users = new ArrayList<>();
    private static JLabel userLabel;
    private static JTextField userText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel successMessage;


    public static void main (String[] args){

        // Initialize user data
        loadUsersFromCSV();

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        // configuring the frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        // configuring the panel
        panel.setLayout(null);

        // configuring the username label
        userLabel = new JLabel("User ID");
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        // configuring the username input
        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // configuring the password label
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        // configuring the password input
        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // configuring the button
        button = new JButton("Login");
        button.setBounds(10,80,80,25);
        button.addActionListener(new GUI());
        panel.add(button);

        successMessage = new JLabel("");
        successMessage.setBounds(10, 110, 300, 25);
        successMessage.setVisible(false);
        panel.add(successMessage);


        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String userId = userText.getText();
        String password = new String(passwordText.getPassword());

        System.out.println("Attempting to login with User ID: " + userId); // Debugging output
        User user = findUserById(userId);

        if (user != null && user.getPassword().equals(password)) {
            successMessage.setText("Logged in successfully as " + user.getName());
            successMessage.setVisible(true);
            // directs the user to their dashboard
           new BankingDashboard(user);
        } else {
            successMessage.setText("Invalid User ID or Password");
            successMessage.setVisible(true); // Show the error message
        }
    }

    private static void loadUsersFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/annagillies/Desktop/Java_Projects/BankingApp/users.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    User user = new User(data[0], data[1], data[2]);
                    Account account = new Account("ACC" + data[0]);
                    user.setAccounts(new ArrayList<>(List.of(account)));
                    users.add(user);
                    System.out.println("SUCCESS");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }

    private static User findUserById(String userId) {
        for (User user : users) {
            if (user.getCustomerID().equals(userId)) {
                return user;
            }
        }
        return null;
    }
}