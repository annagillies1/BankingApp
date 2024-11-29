import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BankingDashboard implements ActionListener {

    private User currentUser;
    private JLabel balanceLabel;
    private JLabel userLabel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton checkBalanceButton;
    private JButton calculateInterestButton;
    private JButton previousTransactionButton;

    public BankingDashboard(User user) {
        this.currentUser = user;
        Account account = currentUser.getAccounts().getFirst();

        // initialising the frame
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(176, 172, 136));

        // the user label
        userLabel = new JLabel("Current user: " + currentUser.getName());
        userLabel.setBounds(10,5,400,25);
        panel.add(userLabel);
        // the balance label
        balanceLabel = new JLabel("Your balance is: £" + account.getBalance());
        balanceLabel.setBounds(10, 20, 300, 25);
        panel.add(balanceLabel);

        // the deposit button
        depositButton = new JButton("Deposit");
        depositButton.setBounds(10, 50, 100, 25);
        depositButton.addActionListener(this);
        panel.add(depositButton);

        // the withdrawal button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(10, 80, 100, 25);
        withdrawButton.addActionListener(this);
        panel.add(withdrawButton);

        // check balance button
        checkBalanceButton = new JButton("Check your balance");
        checkBalanceButton.setBounds(10, 110, 150, 25);
        checkBalanceButton.addActionListener(this);
        panel.add(checkBalanceButton);

        // calculate interest button
        calculateInterestButton = new JButton("Check your interest");
        calculateInterestButton.setBounds(10, 140, 150, 25);
        calculateInterestButton.addActionListener(this);
        panel.add(calculateInterestButton);

        // previous transaction button
        previousTransactionButton = new JButton("Check previous transactions");
        previousTransactionButton.setBounds(10, 170, 250, 25);
        previousTransactionButton.addActionListener(this);
        panel.add(previousTransactionButton);




        depositButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                System.out.println("Mouse entered button area.");
                depositButton.setBackground(Color.WHITE);
                depositButton.setFont(new Font("SansSerif", Font.BOLD, 12));
            }

            @Override
            public void mouseExited(MouseEvent evt){
                System.out.println("Mouse exited button area.");
                depositButton.setBackground(Color.WHITE);
                depositButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
            }
        });

        withdrawButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                System.out.println("Mouse entered button area.");
                withdrawButton.setBackground(Color.WHITE);
                withdrawButton.setFont(new Font("SansSerif", Font.BOLD, 12));
            }

            @Override
            public void mouseExited(MouseEvent evt){
                System.out.println("Mouse exited button area.");
                withdrawButton.setBackground(Color.WHITE);
                withdrawButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
            }
        });


        // CONFIGURING THE MOUSE BUTTON EVENTS
        calculateInterestButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                System.out.println("Mouse entered button area.");
                calculateInterestButton.setBackground(Color.WHITE);
                calculateInterestButton.setFont(new Font("SansSerif", Font.BOLD, 12));
            }

            @Override
            public void mouseExited(MouseEvent evt){
                System.out.println("Mouse exited button area.");
                calculateInterestButton.setBackground(Color.WHITE);
                calculateInterestButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
            }
        });

        checkBalanceButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                System.out.println("Mouse entered button area.");
                checkBalanceButton.setBackground(Color.WHITE);
                checkBalanceButton.setFont(new Font("SansSerif", Font.BOLD, 12));
            }

            @Override
            public void mouseExited(MouseEvent evt){
                System.out.println("Mouse exited button area.");
                checkBalanceButton.setBackground(Color.WHITE);
                checkBalanceButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
            }
        });

        previousTransactionButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent evt){
                System.out.println("Mouse entered button area.");
                previousTransactionButton.setBackground(Color.WHITE);
                previousTransactionButton.setFont(new Font("SansSerif", Font.BOLD, 12));
            }

            @Override
            public void mouseExited(MouseEvent evt){
                System.out.println("Mouse exited button area.");
                previousTransactionButton.setBackground(Color.WHITE);
                previousTransactionButton.setFont(new Font("SansSerif", Font.PLAIN, 12));
            }
        });

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Account account = currentUser.getAccounts().getFirst();


        if (e.getSource() == depositButton) {
            String amountStr = JOptionPane.showInputDialog("Enter the deposit amount");
            try {
                int amount = Integer.parseInt(amountStr);
                account.deposit(amount);
                refreshBalanceLabel();  // Refresh the balance label
                JOptionPane.showMessageDialog(null, "You have deposited £" + amount + ". Your new balance is £" + account.getBalance() + ".");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid amount entered.");
            }
    } else if (e.getSource() == withdrawButton) {
            String amountStr = JOptionPane.showInputDialog("Enter the withdrawal amount");
            try {
                int amount = Integer.parseInt(amountStr);
                account.withdraw(amount);
                refreshBalanceLabel();  // Refresh the balance label
                JOptionPane.showMessageDialog(null, "You have withdrawn £" + amount + ". Your new balance is £" + account.getBalance() + ".");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid amount entered.");
            }
    } else if (e.getSource() == checkBalanceButton) {
            JOptionPane.showMessageDialog(null, "Your balance is: £" + account.getBalance());
        } else if (e.getSource() == calculateInterestButton) {
            String yearsStr = JOptionPane.showInputDialog("Enter the number of years for interest calculation:");
            try {
                int years = Integer.parseInt(yearsStr);
                String interestMessage = account.calculateInterest(years);  // Get the result message
                JOptionPane.showMessageDialog(null, interestMessage);  // Show the message in a dialog box
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid number of years entered.");
            }
        } else if (e.getSource() == previousTransactionButton) {
            // Assuming Account has a method to get the transaction history
            String transactionHistory = account.getTransactionHistory(); // Fetch transaction history
            if (transactionHistory == null || transactionHistory.isEmpty()) {
                transactionHistory = "No transactions available.";
            }
            JOptionPane.showMessageDialog(null, transactionHistory, "Previous Transactions", JOptionPane.INFORMATION_MESSAGE);
        }


    }

    private void refreshBalanceLabel() {
        Account account = currentUser.getAccounts().getFirst();
        balanceLabel.setText("Your balance is: £" + account.getBalance());
    }

}
// CLOSE INITIAL WINDOW
