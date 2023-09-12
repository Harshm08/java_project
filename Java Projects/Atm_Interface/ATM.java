import java.util.Scanner;
// import java.lang.*;

public class ATM {
    private double balance;
    private int accountNumber;
    private int pin;

    public ATM(int accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited :" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn : $" + amount);
        } else {
            System.out.println("There is no Insufficient amount in you Account.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public static void main(String[] args) {
        ATM atm = new ATM(494981000, 1234, 5000.0);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");
        System.out.print("Enter your account number: ");
        int enteredAccount = scanner.nextInt();

        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredAccount == atm.accountNumber && enteredPin == atm.pin) {
            int choice;
            do {
                System.out.println("\n1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.println("Your balance: $" + atm.checkBalance());
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 4);
        } else {
            System.out.println("Invalid account number or PIN. Please try again.");
        }
    }
}