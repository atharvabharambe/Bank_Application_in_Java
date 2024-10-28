import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts;
    private int nextAccountId;

    public Bank() {
        accounts = new HashMap<>();
        nextAccountId = 1;
    }

    public int createAccount(String name, AccountType accountType) {
        int accountId = nextAccountId++;
        accounts.put(accountId, new Account(name, 0.0, accountType));
        return accountId;
    }

    public void deposit(int accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposited $" + amount + " to account ID " + accountId);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(int accountId, double amount) {
        Account account = accounts.get(accountId);
        if (account != null) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrew $" + amount + " from account ID " + accountId);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public double checkBalance(int accountId) {
        Account account = accounts.get(accountId);
        return account != null ? account.getBalance() : -1;
    }
}
