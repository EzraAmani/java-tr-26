package Excercises.javase010.BankAccount;

class SavingsAccount extends BankAccount {
    private double interestRate;
    private static final double MINIMUM_BALANCE = 100.0;

    public SavingsAccount(String accountHolder, double initialBalance, double interestRate)
            throws InvalidAmountException {
        super(accountHolder, initialBalance);
        if (interestRate < 0) {
            throw new InvalidAmountException("Interest rate cannot be negative");
        }
        if (initialBalance < MINIMUM_BALANCE) {
            throw new InvalidAmountException(String.format(
                    "Savings account requires minimum balance of $%.2f", MINIMUM_BALANCE));
        }
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) throws InvalidAmountException {
        if (interestRate < 0) {
            throw new InvalidAmountException("Interest rate cannot be negative");
        }
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        if (getBalance() - amount < MINIMUM_BALANCE) {
            throw new InsufficientFundsException(String.format(
                    "Cannot withdraw. Minimum balance of $%.2f must be maintained", MINIMUM_BALANCE));
        }
        super.withdraw(amount);
    }

    public void applyInterest() {
        double interest = getBalance() * (interestRate / 100);
        try {
            deposit(interest);
            System.out.printf("Interest applied: $%.2f at rate %.2f%%\n", interest, interestRate);
        } catch (InvalidAmountException e) {
            System.out.println("Error applying interest: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("%s | Type: Savings | Interest Rate: %.2f%%",
                super.toString(), interestRate);
    }
}
