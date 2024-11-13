package BankManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    bank.register(username, password);
                }
                case 2 -> {
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    int userType = bank.login(username, password);
                    if (userType == 1) {
                        adminMenu(bank, scanner);
                    } else if (userType == 2) {
                        userMenu(bank, scanner);
                    }
                }
                case 3 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    private static void userMenu(Bank bank, Scanner scanner) {
        int choice;
        do {
            System.out.println("\n1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Show Statement");
            System.out.println("6. Logout");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> openAccount(bank, scanner);
                case 2 -> depositAmount(bank, scanner);
                case 3 -> withdrawAmount(bank, scanner);
                case 4 -> bank.showAllBalances();
                case 5 -> showStatement(bank, scanner);
                case 6 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }

    private static void adminMenu(Bank bank, Scanner scanner) {
        int choice;
        do {
            System.out.println("\n1. View All Accounts");
            System.out.println("2. Logout");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> bank.displayAllAccounts();
                case 2 -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (true);
    }

    private static void openAccount(Bank bank, Scanner scanner) {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter account type (savings/checking): ");
        String accountType = scanner.nextLine();
        
        double initialDeposit = getAmount(scanner, "Enter initial deposit: ");
        bank.openAccount(name, accountType, initialDeposit);
    }

    private static void depositAmount(Bank bank, Scanner scanner) {
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        double amount = getAmount(scanner, "Enter amount to deposit: ");
        bank.deposit(accNumber, amount);
    }

    private static void withdrawAmount(Bank bank, Scanner scanner) {
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        double amount = getAmount(scanner, "Enter amount to withdraw: ");
        bank.withdraw(accNumber, amount);
    }

    private static void showStatement(Bank bank, Scanner scanner) {
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        bank.showStatement(accNumber);
    }

    private static double getAmount(Scanner scanner, String prompt) {
        double amount = 0.0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print(prompt);
            try {
                amount = scanner.nextDouble();
                if (amount < 0) {
                    System.out.println("Amount cannot be negative. Please try again.");
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine();
            }
        }
        return amount;
    }
}
