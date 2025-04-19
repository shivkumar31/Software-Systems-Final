package src.account;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AccountManager {
    String filePath;
    private List<Account> accounts;

    // Gets all the accounts upon intializaiton and the file path
    public AccountManager(String filePath) {
        this.filePath = filePath;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Gson gson = new Gson();
            accounts = gson.fromJson(reader, new TypeToken<List<Account>>() {
            }.getType());
            reader.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    // getter for the accounts
    public Account getAccountByName(String name) {
        for (Account a : accounts) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

    // adds an account to the list and updates the file accordingly
    public void addAccount(Account account) {
        accounts.add(account);
        saveAccounts();
    }

    // removes an account from the list and updates the file accordingly
    public void removeAccount(String accountName) {
        for (Account acc : accounts) {
            if (accountName == acc.getName()) {
                accounts.remove(acc);
            }
        }
        saveAccounts();
    }

    // updates the file with the current state of the accounts list
    public void saveAccounts() {
        if (accounts != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.filePath))) {
                Gson gson = new Gson();
                gson.toJson(accounts, writer);
            } catch (Exception e) {
                System.out.println("Error: " + e.getLocalizedMessage());
            }
        } else {
            System.out.println("Accounts is empty.");
        }

    }

    // mostly for debugging, but prints all the accounts
    public void printAccounts() {
        if (accounts != null) {
            for (Account acc : accounts) {
                System.out.println("Name: " + acc.getName() + ", Current amount: " + acc.getBalance());
            }
        } else {
            System.out.println("No accounts found.");
        }
    }
}
