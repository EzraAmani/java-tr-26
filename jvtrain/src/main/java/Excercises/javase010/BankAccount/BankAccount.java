package Excercises.javase010.BankAccount;

import java.util.concurrent.atomic.AtomicInteger;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private static final AtomicInteger accountCounter = new AtomicInteger(1000);

    public BankAccount(String accountHolder, double initialBalance) throws InvalidAmountException {
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        if (initialBalance < 0) {
            throw new InvalidAmountException("Initial balance cannot be negative");
        }

        this.accountNumber = "ACC" + accountCounter.getAndIncrement();
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.trim().isEmpty()) {
            this.accountHolder = accountHolder;
        }
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        balance += amount;
        System.out.printf("Deposited $%.2f successfully. New balance: $%.2f\n", amount, balance);
    }

    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
        System.out.printf("Withdrew $%.2f successfully. New balance: $%.2f\n", amount, balance);
    }

    @Override
    public String toString() {
        return String.format("Account Number: %s | Holder: %s | Balance: $%.2f",
                accountNumber, accountHolder, balance);
    }
}
