import java.security.SecureRandom;
import java.text.DecimalFormat;

public class Aviator {
    SecureRandom ran = new SecureRandom();
    double guess;

    public Aviator(double guess){
        this.guess = guess; //mapping parameters
    }

    public void plane(PublicTest bal){
        //Accessing Account balance 
        double balance = bal.getBalance();
        double deposit = bal.getDeposit();
        //Creating "private" variables for simplicity and readability
        double newBalance;
        double newDeposit;

        int lowerLimit = ran.nextInt(0, 7); //randomize lower limit
        int upperLimit = ran.nextInt(6, 13); // randomize upper limit

        float multiplier = ran.nextFloat(lowerLimit, upperLimit);

        DecimalFormat df  = new DecimalFormat("#.###"); // Rounding to 3 decimal Places
        String dFloat = df.format(multiplier);

        System.out.println("The plane took of at 'x" +dFloat+ "'");

        if (guess <= multiplier){
            System.out.println("Yayyy!!!!! You won");
            newBalance = balance - deposit;
            newDeposit = deposit*guess;

            newBalance += newDeposit;
            balance = newBalance;
            bal.setBalance(balance);
            
        }
        else{
            System.out.println("Sorry bro, you lost");
            newBalance = balance - deposit;
            newDeposit = 0;
            balance = newBalance;
            bal.setBalance(balance);
        }

        System.out.println("New balance = " + bal.getBalance() );

        
    }


}
