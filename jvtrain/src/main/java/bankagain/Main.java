package bankagain;

public class Main {
    public static void main(String[] args) {
        // reference type //object
        BankAccount account6 = new SavingsAccount("123456", "Ezra", 0.5);

        account6.deposit(10000);
        // account6.displayInfo();

        // System.out.println(account6.getBalance());

        account6.withdraw(2000);

    }

}
