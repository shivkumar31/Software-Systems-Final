package src;

import src.account.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager("./account.json");
        Scanner sc = new Scanner(System.in);
        Account currentAccount = null;
        String signInOption;
        while (true) {
            signInOption = Util.intro(sc);

            if (signInOption.equals("1")) {
                currentAccount = Util.signUp(sc, accountManager);
            } else if (signInOption.equals("2")) {
                currentAccount = Util.login(sc, accountManager);
            } else {
                break;
            }
            Util.gameMenu(sc, currentAccount, accountManager);

        }

        sc.close();
    }

}