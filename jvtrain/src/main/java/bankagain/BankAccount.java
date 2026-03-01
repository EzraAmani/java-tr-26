package bankagain;

public abstract class BankAccount {

    // attributes
    private String accountNumber;
    private String accountHolder;
    protected double balance;

    // constructor method
    public BankAccount(String accountNumber, String accountHolder) {
        try {
            setAccountHolder(accountHolder);
        } catch (InvalidAccountHolderException e) {
            System.out.println(e.getMessage());
        }

        setAccountNumber(accountNumber);
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;

            System.out.println("You have deposted KES: " + amount);
        }
    }

    // to widthdraw money

    public abstract void withdraw(double amount);

    public void setAccountHolder(String accountHolder) throws InvalidAccountHolderException {
        if (accountHolder != null && accountHolder.length() > 5) {
            throw new InvalidAccountHolderException("Account holder name cannot exceed 5 characters");
        }
        this.accountHolder = accountHolder;
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
