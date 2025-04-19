package src;

import java.util.InputMismatchException;
import java.util.Scanner;

import src.account.*;
import src.games.*;
import src.games.BlackJack.BlackJack;

public class Util {

    // Intro loop
    public static String intro(Scanner sc) {
        String option;
        while (true) {
            try {
                System.out.print(
                        "Welcome to the Crimson Casino! Would you like to:\n" +
                                " 1: Sign Up?\n" +
                                " 2: Log in?\n" +
                                "Enter the corresponding number to continue (or press 'q' to quit): ");
                option = sc.nextLine();
                if (option.equals("1") || option.equals("2") || option.equals("q")) {
                    return option;
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                continue;
            }
        }
    }

    // Loop for signing users up
    public static Account signUp(Scanner sc, AccountManager accountManager) {
        String username;
        boolean isUnique;
        while (true) {
            System.out.print(
                    "Enter your username (can be anything as long as it's unique): ");
            username = sc.nextLine();
            isUnique = true;
            for (Account acc : accountManager.getAccounts()) {
                if (acc.getName().equals(username)) {
                    System.out.println(
                            "That username is already taken. Please choose another one.\n");
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                break;
            }
        }

        Account a = new Account(username, 100);
        accountManager.addAccount(a);
        return a;
    }

    // Log the user in
    public static Account login(Scanner sc, AccountManager accountManager) {

        String username;

        while (true) {
            System.out.print("Please Login with your your username: ");
            username = sc.nextLine();

            for (Account acc : accountManager.getAccounts()) {
                if (username.equals(acc.getName())) {
                    return acc;
                }
            }
            System.out.println("Sorry, that username doesn't exist. Please try again.");
        }
    }

    // The main menu of the games
    public static boolean gameMenu(Scanner sc, Account currentAccount, AccountManager accountManager) {
        String gameOption = null;
        boolean validGameOption = false;

        while (true) {
            while (validGameOption == false) {
                try {
                    System.out.print(
                            "Would you like to play:\n" +
                                    "1: Slotomainia?\n" +
                                    "2: Blackjack?\n" +
                                    "(Type the corresponding number or press 'q' to quit): ");
                    gameOption = sc.nextLine();
                    if (gameOption.equals("1") || gameOption.equals("2") || gameOption.equals("q")) {
                        validGameOption = true;
                    }
                } catch (InputMismatchException e) {
                    sc.nextLine();
                }
            }

            if (gameOption.equals("1")) {
                Slotomainia s = new Slotomainia(currentAccount, accountManager);
                s.run();
                validGameOption = false;
            } else if ("2".equals(gameOption)) {
                BlackJack b = new BlackJack(currentAccount, accountManager);
                b.run();
                validGameOption = false;
            } else if (gameOption.equals("q")) {
                return false;
            }
        }
    }
}
