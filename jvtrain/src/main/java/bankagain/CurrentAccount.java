package bankagain;

public class CurrentAccount extends BankAccount {
    public CurrentAccount(String accNo, String holder) {
        super(accNo, holder); // ✅ call parent constructor
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount; // allows overdraft
    }
}
