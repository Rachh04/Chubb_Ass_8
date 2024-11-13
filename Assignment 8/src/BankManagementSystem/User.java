package BankManagementSystem;

import java.util.ArrayList;

public class User {
    private final String username;
    private final String password;
    private final ArrayList<Account> accounts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Account> getAccounts() {
        return new ArrayList<>(accounts); // Returns a copy for encapsulation
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }
}
