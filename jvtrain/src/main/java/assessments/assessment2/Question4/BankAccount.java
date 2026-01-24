package assessments.assessment2.Question4;

public class BankAccount {
    // Private fields (encapsulation)
    private String accountNumber;
    private String accountHolder;
    protected double balance; // protected so subclasses can access

    // Constructor with validation
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        if (accountHolder == null || accountHolder.isEmpty()) {
            throw new IllegalArgumentException("Account holder cannot be empty");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    // Withdraw method (basic behavior)
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            System.out.println("Insufficient balance");
            return;
        }
        balance -= amount;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Display account info
    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}
