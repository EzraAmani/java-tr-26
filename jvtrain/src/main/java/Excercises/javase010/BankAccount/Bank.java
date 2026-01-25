package Excercises.javase010.BankAccount;

import java.util.*;

class Bank {
    private Map<String, BankAccount> accounts;
    private Scanner scanner;

    public Bank() {
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    // Add account
    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account created successfully: " + account.getAccountNumber());
    }

    // Find account
    public BankAccount findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // Display all accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        System.out.println("\n=== ALL ACCOUNTS ===");
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
        System.out.println("===================\n");
    }

    // Calculate total balance
    public double calculateTotalBalance() {
        double total = 0;
        for (BankAccount account : accounts.values()) {
            total += account.getBalance();
        }
        return total;
    }

    // Apply interest to all savings accounts
    public void applyInterestToSavingsAccounts() {
        int count = 0;
        for (BankAccount account : accounts.values()) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).applyInterest();
                count++;
            }
        }
        System.out.printf("Interest applied to %d savings account(s)\n", count);
    }

    // Display menu and handle user input
    public void displayMenu() {
        while (true) {
            System.out.println("\n=== Bank Account System ===");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Apply Interest (Savings)");
            System.out.println("7. Display All Accounts");
            System.out.println("8. Calculate Total Bank Balance");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        createSavingsAccount();
                        break;
                    case 2:
                        createCheckingAccount();
                        break;
                    case 3:
                        performDeposit();
                        break;
                    case 4:
                        performWithdrawal();
                        break;
                    case 5:
                        checkBalance();
                        break;
                    case 6:
                        applyInterestToSavingsAccounts();
                        break;
                    case 7:
                        displayAllAccounts();
                        break;
                    case 8:
                        System.out.printf("Total Bank Balance: $%.2f\n", calculateTotalBalance());
                        break;
                    case 9:
                        System.out.println("Thank you for using our banking system!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void createSavingsAccount() {
        try {
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine();

            System.out.print("Enter initial deposit (min $100): ");
            double balance = scanner.nextDouble();

            System.out.print("Enter interest rate (%): ");
            double rate = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            SavingsAccount account = new SavingsAccount(name, balance, rate);
            addAccount(account);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // Clear invalid input
        } catch (InvalidAmountException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
    }

    private void createCheckingAccount() {
        try {
            System.out.print("Enter account holder name: ");
            String name = scanner.nextLine();

            System.out.print("Enter initial deposit: ");
            double balance = scanner.nextDouble();

            System.out.print("Enter overdraft limit: ");
            double overdraft = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            CheckingAccount account = new CheckingAccount(name, balance, overdraft);
            addAccount(account);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
            scanner.nextLine(); // Clear invalid input
        } catch (InvalidAmountException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
    }

    private void performDeposit() {
        try {
            System.out.print("Enter account number: ");
            String accNumber = scanner.nextLine();

            BankAccount account = findAccount(accNumber);
            if (account == null) {
                System.out.println("Account not found.");
                return;
            }

            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            account.deposit(amount);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void performWithdrawal() {
        try {
            System.out.print("Enter account number: ");
            String accNumber = scanner.nextLine();

            BankAccount account = findAccount(accNumber);
            if (account == null) {
                System.out.println("Account not found.");
                return;
            }

            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            account.withdraw(amount);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.nextLine();
        } catch (InsufficientFundsException | InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void checkBalance() {
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();

        BankAccount account = findAccount(accNumber);
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("\n=== ACCOUNT DETAILS ===");
        System.out.println(account);
        System.out.printf("Current Balance: $%.2f\n", account.getBalance());
        System.out.println("=====================\n");
    }

    public void close() {
        scanner.close();
    }
}
