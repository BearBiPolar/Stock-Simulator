import java.util.concurrent.ThreadLocalRandom;
/**
 * Write a description of class Stock here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Stock
{
    // instance variables - replace the example below with your own
    private double price;
    private int day;
    private String name;
    double amountOfChange;
    double change;
    int volatility;
    int available;
    int owned;

    public Stock()
    {
        this.price = 100;
        this.day = 0;
        this.name = "AMZN";
    }

    /**
     * Constructor for objects of class Stock
     */
    public Stock(double price)
    {
        // initialise instance variables
        this.price = price;
        this.day = 0;
        this.name = "AMZN";
    }

    /**
     * Constructor for objects of class Stock
     */
    public Stock(double price, String name)
    {
        // initialise instance variables
        this.price = price;
        this.day = 0;
        this.name = name;
    }

    /**
     * Fluctuates the stock price by a precentage of its previous price.
     */
    public void randomize()
    {
        volatility = 5;
        amountOfChange = (double)ThreadLocalRandom.current().nextInt(-volatility, volatility+2);
        change = amountOfChange*price/100;
        price = price + change;
        dailyNews();
    }
    
    public void buyStock(int number)
    {
        
    }
    
    /**
     * Returns the price of this stock
     * 
     * @return    the price of this stock
     */
    public double returnPrice()
    {
        // put your code here
        return this.price;
    }

    public void dailyNews()
    {
        day++;
        System.out.println("Today is your Day #" + day + " of stock trading. Here are the updates: ");
        if(amountOfChange > 0)
        {
            System.out.println("Good news!");
            System.out.println(name + " is up " + amountOfChange + "% at $" + returnPrice() + " from $" + (returnPrice() - change) + ".");
        }
        else if(amountOfChange < 0)
        {
            System.out.println("Bad news!");
            System.out.println(name + " is down " + amountOfChange + "% at $" + returnPrice() + " from $" + (returnPrice() - change) + ".");
        }
        else
        {
            System.out.println(name + " is constant at $" + returnPrice() + ".");
        }
    }
}
