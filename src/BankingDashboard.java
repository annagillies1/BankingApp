import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankingDashboard implements ActionListener {

    private User currentUser;
    private JLabel balanceLabel;
    private JButton depositButton;
    private JButton withdrawButton;
    private JButton checkBalanceButton;
    private JButton calculateInterestButton;
    private JButton previousTransactionButton;

    public BankingDashboard(User user) {
        this.currentUser = user;

        // initialising the frame
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        // the balance label
        balanceLabel = new JLabel("Your balance is: £" + currentUser.getAccounts().get(0).getBalance());
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
        previousTransactionButton.setBounds(10, 170, 150, 25);
        previousTransactionButton.addActionListener(this);
        panel.add(previousTransactionButton);

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
                JOptionPane.showMessageDialog(null, "You have deposited £" + amount + " your new balance is £" + account.getBalance() + ".");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid amount entered.");
            }
        } else if (e.getSource() == withdrawButton) {
            String amountStr = JOptionPane.showInputDialog("Enter the withdrawal amount");
            try {
                int amount = Integer.parseInt(amountStr);
                account.withdraw(amount);
                JOptionPane.showMessageDialog(null, "You have withdrawn £" + amount + " your new balance is £" + account.getBalance() + ".");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid amount entered");
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
        }
    }
}
// CLOSE INITIAL WINDOW
