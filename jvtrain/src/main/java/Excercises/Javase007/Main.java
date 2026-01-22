package Excercises.Javase007;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("12345", "Jeff Bezos", 100000000);
        account1.displayBalance();
        account1.deposit(10000);
    }

}
