package src.games;

import src.account.Account;
import src.account.AccountManager;

public abstract class Game {
    protected Account account;
    protected AccountManager accountManager;

    public Game(Account account, AccountManager accountManager) {
        this.account = account;
        this.accountManager = accountManager;
    }

    public abstract void run();
}
