package assessments.assessment2.Question4;

public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder,
            double balance, double overdraftLimit) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw to allow overdraft

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        // it will now countinue and apply the overdraft and the account can have a
        // negative balance

        if (balance - amount < -overdraftLimit) {
            System.out.println("Overdraft limit exceeded");
            return;
        }

        balance -= amount;
    }
}
