import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User("12345", "54321");

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();

        if (user.authenticate(userId, pin)) {
            boolean quit = false;
            while (!quit) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Transactions History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        user.printTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        user.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        user.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient User ID: ");
                        String recipientId = scanner.nextLine();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        if (recipientId.equals(user.getUserId())) {
                            System.out.println("Cannot transfer to the same account.");
                        } else {
                            User recipient = new User(recipientId, "54321"); // Simplified for demo
                            user.transfer(transferAmount, recipient);
                        }
                        break;
                    case 5:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid User ID or PIN!");
        }
        scanner.close();
    }
}
