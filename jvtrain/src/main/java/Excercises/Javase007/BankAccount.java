package Excercises.Javase007;

public class BankAccount {
    public String accountNumber;
    public String accountHolder;
    public double balance;

    // Default constructor
    public BankAccount() {
        accountNumber = "Unknown";
        accountHolder = "Unknown";
        balance = 0.0;
    }

    // Constructor with account info
    public BankAccount(String number, String holder) {
        accountNumber = number;
        accountHolder = holder;
        balance = 0.0;
    }

    // Constructor with all properties
    public BankAccount(String number, String holder, double initialBalance) {
        accountNumber = number;
        accountHolder = holder;
        balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount");
        }
    }

    public void displayBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}
