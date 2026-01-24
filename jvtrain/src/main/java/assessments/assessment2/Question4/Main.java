package assessments.assessment2.Question4;

public class Main {
    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount(
                "SA123", "Alice", 500, 0.05);

        BankAccount checking = new CheckingAccount(
                "CA456", "Bob", 300, 200);

        // Polymorphic array
        BankAccount[] accounts = { savings, checking };

        for (BankAccount account : accounts) {
            account.displayInfo();
            account.withdraw(450); // different behavior based on object type
            System.out.println("Balance after withdrawal: $" + account.getBalance());
            System.out.println();
        }

        // Apply interest (SavingsAccount-specific)
        SavingsAccount sa = (SavingsAccount) savings;
        sa.applyInterest();
        System.out.println("Savings balance after interest: $" + sa.getBalance());
    }
}
