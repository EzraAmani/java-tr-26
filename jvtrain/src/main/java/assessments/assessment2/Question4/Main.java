package assessments.assessment2.Question4;

public class Main {
    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount(
                "SA123", "Alice", 500, 0.05);

        BankAccount checking = new CheckingAccount(
                "CA456", "Bob", 300, 200);

        savings.deposit(100000);
    }
}
