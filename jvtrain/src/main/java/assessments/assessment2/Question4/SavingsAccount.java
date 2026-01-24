package assessments.assessment2.Question4;

public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder,
            double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Override withdraw to maintain minimum balance of $100
    @Override
    public void withdraw(double amount) {
        if (balance - amount < 100) {
            System.out.println("Withdrawal denied. Minimum balance of $100 required.");
            return;
        }
        super.withdraw(amount);
    }

    // Apply interest
    public void applyInterest() {
        balance += balance * interestRate;
    }
}
