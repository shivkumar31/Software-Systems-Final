public class Player {
    private final String name;
    private double balance;

    public Player(String name, double initialBalance){
        this.name = name;
        this.balance=initialBalance;
    }
    public String getName(){
        return name;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }
    public double getBalance(){
        return balance;
    }

    public boolean placeBet(double amount){
        if (amount <=balance){
            balance-=amount;
            return true;
        }
        else{
            System.out.println("Insufficient balance to place bet :( ");
            return false;
        }
    }
    public void winBet(double amount){
        balance+=amount;
    }
}
