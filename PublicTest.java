//Feel free to add features you think you'll need or send a text on the group and I'll add it

// Some parts of the code have been commented out cause I was too scared to delete them. I didn't want to break my program by accident


import java.util.Scanner;
public class PublicTest {
     // Everyone player starts with $100
    public double balance = 100;
    public double deposit = 0;
     // games played affect the balance a sample class will be made

    public double getBalance(){
        return balance;
    }
    public double getDeposit(){
        return deposit;
    }
    public void setDeposit(double newDeposit){
        this.deposit = newDeposit;
    }
    public void setBalance(double newBalance){
        this.balance = newBalance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PublicTest bal = new PublicTest(); //declare main class


        System.out.println("Enter 1. To play Coin Flip");
        System.out.println("Enter 2. to play Aviator");
        System.out.print(">> ");
        char game = sc.next().charAt(0);

        System.out.println("How much would you like to deposit it into this game");
        System.out.print(">> ");
        double deposit = sc.nextDouble();
        sc.nextLine();
        bal.setDeposit(deposit);
        

        switch (game) {
            case '1':
                System.out.println("Test your luck in this classic Coin Flip Game! Each round, the player chooses either Heads or Tails. The coin is flipped, and if your guess matches the result, you win! It’s quick, easy, and all about trusting your instincts. How many in a row can you get right?");
                System.out.print("Enter 'H' for heads or 'T' for tails >> ");
                char choice = sc.next().charAt(0);
                CoinFlip coin = new CoinFlip(choice);
                // coin.accessVariables(bal);
                coin.flipCoin(bal);
                break;
            case '2':
                System.out.println("In this game, a random multiplier is secretly generated each round. The player’s goal is to guess a number with a decimal number that is less than or equal to the hidden multiplier. If the guess is equal to or below the multiplier, the player wins and their deposit is multiplied by their guess. But if the guess is too high, they lose the round. It’s a game of precision and intuition—how close can you get without going over? ");
                System.out.print("So, what's your guess? >> ");
                double guess = sc.nextDouble();
                sc.nextLine();
                Aviator plane = new Aviator(guess);
                plane.plane(bal);
                break;
            default:
                System.out.println("Invalid game selection");
                break;
        }


        sc.close();
    }
}
