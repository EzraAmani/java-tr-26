package Excercises.javase010.BankAccount;

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountHolder, double initialBalance, double overdraftLimit)
            throws InvalidAmountException {
        super(accountHolder, initialBalance);
        if (overdraftLimit < 0) {
            throw new InvalidAmountException("Overdraft limit cannot be negative");
        }
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double overdraftLimit) throws InvalidAmountException {
        if (overdraftLimit < 0) {
            throw new InvalidAmountException("Overdraft limit cannot be negative");
        }
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        double availableBalance = getBalance() + overdraftLimit;
        if (amount > availableBalance) {
            throw new InsufficientFundsException(String.format(
                    "Exceeds overdraft limit. Available: $%.2f (Balance: $%.2f + Overdraft: $%.2f)",
                    availableBalance, getBalance(), overdraftLimit));
        }

        double newBalance = getBalance() - amount;
        if (newBalance < 0) {
            System.out.printf("Warning: Overdraft used. Current balance: $%.2f\n", newBalance);
        }

        try {
            java.lang.reflect.Field balanceField = BankAccount.class.getDeclaredField("balance");
            balanceField.setAccessible(true);
            balanceField.set(this, newBalance);
            System.out.printf("Withdrew $%.2f successfully. New balance: $%.2f\n", amount, newBalance);
        } catch (Exception e) {
            System.out.println("Error processing withdrawal: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("%s | Type: Checking | Overdraft Limit: $%.2f",
                super.toString(), overdraftLimit);
    }
}
