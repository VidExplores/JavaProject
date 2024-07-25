import java.util.ArrayList;

public class User {
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public boolean authenticate(String userId, String pin) {
        return this.userId.equals(userId) && this.pin.equals(pin);
    }

    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdraw: $" + amount);
            System.out.println("Withdraw successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposit: $" + amount);
        System.out.println("Deposit successful. New balance: $" + balance);
    }

    public void transfer(double amount, User recipient) {
        if (amount <= balance) {
            balance -= amount;
            recipient.deposit(amount);
            transactionHistory.add("Transfer: $" + amount + " to " + recipient.getUserId());
            System.out.println("Transfer successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
