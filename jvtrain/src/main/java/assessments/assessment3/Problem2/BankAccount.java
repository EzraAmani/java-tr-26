package assessments.assessment3.Problem2;

import javax.security.auth.login.AccountNotFoundException;

public class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder) {
        setAccountHolder(accountHolder);
        setAccountNumber(accountNumber);
        this.balance = 0;

    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;

    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;

    }

    public void deposit(int amount) throws InvalidTransactionException, InsufficientFundsException,
            AccountNotFoundException {
        if (amount > 0) {
            System.out.println("You have deposited KES: " + amount);
            balance = balance + amount;
        } else {
            throw new InvalidTransactionException("Invalid transaction...");
        }
    }

    public void withdraw(int amount) throws InsufficientFundsException, AccountNotFoundException,
            InvalidTransactionException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insuficient funds exception");
        } else {
            balance = balance - amount;
            System.out.println("You have withdrawn KES: " + amount);
        }
    }

    public void transfer(BankAccount fromAccount, BankAccount toAccount, double amount)
            throws InsufficientFundsException, InvalidTransactionException, AccountNotFoundException {

        if (amount <= 0) {
            throw new InvalidTransactionException("Invalid transaction...");

        }

        if (fromAccount.balance < amount) {
            System.out.println("Insufficient funds in source account.");

        }

        if (fromAccount.accountNumber == (toAccount.accountNumber)) {
            throw new AccountNotFoundException("You entered and Invalid account");
        }

        // Performing transfer
        fromAccount.balance = balance - amount;
        toAccount.balance = balance + amount;

        System.out.println("Successfully transferred KES" + amount +
                " from account " + fromAccount.accountNumber +
                " to account " + toAccount.accountNumber);

    }

}
