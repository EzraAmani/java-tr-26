package Excercises.javase010.BankAccount;

//import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // some sample accounts for testing
        try {
            // Create a Savings Account
            SavingsAccount johnAccount = new SavingsAccount(
                    "John Doe", // Account holder name
                    1000.0, // Initial balance (must be ≥ $100)
                    3.5 // Interest rate in %
            );

            System.out.println("Account created successfully!");
            System.out.println("Account Number: " + johnAccount.getAccountNumber());
            System.out.println("Holder: " + johnAccount.getAccountHolder());
            System.out.println("Balance: $" + johnAccount.getBalance());
            System.out.println("Interest Rate: " + johnAccount.getInterestRate() + "%");

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
