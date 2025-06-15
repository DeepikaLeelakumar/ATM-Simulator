import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    // PIN verification
    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // Show balance
    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn ₹" + amount);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM userATM = new ATM(5000, 1234); // Initial balance ₹5000, PIN 1234

        System.out.print("Enter your 4-digit PIN: ");
        int inputPin = scanner.nextInt();

        if (userATM.verifyPin(inputPin)) {
            int choice;
            do {
                System.out.println("\n====== ATM Menu ======");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        userATM.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ₹");
                        double depositAmt = scanner.nextDouble();
                        userATM.deposit(depositAmt);
                        break;
                    case 3:
                        System.out.print("Enter withdraw amount: ₹");
                        double withdrawAmt = scanner.nextDouble();
                        userATM.withdraw(withdrawAmt);
                        break;
                    case 4:
                        System.out.println("Thank you for using our ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }

        scanner.close();
    }
}
