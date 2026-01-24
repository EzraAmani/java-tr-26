package bankagain;

public abstract class BankAccount {

    // objects
    private String accountNumber;
    private String accountHolder;
    protected double balance;

    // constructor method
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
    }

    // to deposit some money

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;

            System.out.println("You have deposted KES: " + amount);
        }
    }

    // to widthdraw money

    public abstract void withdraw(double amount);

    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.isEmpty()) {
            this.accountHolder = accountHolder;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void displayInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

}
