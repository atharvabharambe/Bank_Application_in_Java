public class Account {
    private String name;
    private double balance;
    private AccountType accountType;

    public Account(String name, double balance, AccountType accountType) {
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getName() {
        return name;
    }
}
