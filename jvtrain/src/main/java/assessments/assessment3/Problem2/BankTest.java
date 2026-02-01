package assessments.assessment3.Problem2;

import javax.security.auth.login.AccountNotFoundException;

public class BankTest {
    public static void main(String[] args) {
        try {
            BankAccount account1 = new BankAccount(123, "Jeff");
            BankAccount account2 = new BankAccount(122, "Kim");

            account1.deposit(10000);
            account1.transfer(account1, account2, 1000);
        } catch (InvalidTransactionException e) {
            System.out.println("Transaction error " + e.getMessage());

        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());

        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());

        }
    }

}
