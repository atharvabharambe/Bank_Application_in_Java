import java.util.Scanner;

public class bankMain {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the Banking Application!");

        while (!exit) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder's name: ");
                    String name = scanner.next();
                    System.out.println("Choose account type: 1. Checking 2. Savings");
                    int typeChoice = scanner.nextInt();
                    AccountType accountType = (typeChoice == 1) ? AccountType.CHECKING : AccountType.SAVINGS;
                    int accountId = bank.createAccount(name, accountType);
                    System.out.println("Account created successfully. Account ID: " + accountId);
                    break;
                case 2:
                    System.out.print("Enter account ID: ");
                    int depositAccountId = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    bank.deposit(depositAccountId, depositAmount);
                    break;
                case 3:
                    System.out.print("Enter account ID: ");
                    int withdrawAccountId = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    bank.withdraw(withdrawAccountId, withdrawAmount);
                    break;
                case 4:
                    System.out.print("Enter account ID: ");
                    int balanceAccountId = scanner.nextInt();
                    double balance = bank.checkBalance(balanceAccountId);
                    System.out.println("Account balance: $" + balance);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Banking Application!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
