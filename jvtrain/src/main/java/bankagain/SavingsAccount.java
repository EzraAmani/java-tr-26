package bankagain;

public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double interestRate) {
        super(accountNumber, accountHolder); // call parent constructor
        this.interestRate = interestRate;
    }

    public void addInterest() {
        balance += balance * interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("You have withdrawn KES: " + amount + " your new balance is KES: " + balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}
