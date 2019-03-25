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
    private String name;
    private int available;
    private int owned;
    private int volatility;
    double amountOfChange;
    double change;
    /**
     * Constructor for objects of class Stock
     */
    public Stock()
    {
        // initialise instance variables
        price = 100;
        name = "AMZN";
        available = 10;
        owned = 0;
    }

    public Stock(int available, String name, double price)
    {
        this.price = price;
        this.available = available;
        this.name = name;
        this.owned = 0;
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
        System.out.println(returnPrice());
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void buyStock(int y)
    {
        // put your code here
        owned = owned + y;
        available = available - y;
    }

    public void sellStock(int y)
    {
        // put your code here
        owned = owned - y;
        available = available + y;
    }
    
    public int returnOwned()
    {
        return owned;
    }

    public double returnPrice()
    {
        return price;
    }

    public String toString()
    {
        String print = "";
        print += "Name: " + name + ", Price: $" + price + ", Available: " + available + ", Owned: " + owned + ".";
        return print;
    }
}
