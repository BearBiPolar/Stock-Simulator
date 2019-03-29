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
    int index;
    
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

    public Stock(int available, int index, String name, double price)
    {
        this.price = price;
        this.available = available;
        this.index = index;
        this.name = name;
        this.owned = 0;
    }

    /**
     * Fluctuates the stock price by a precentage of its previous price.
     */
    public void randomize()
    {
        volatility = 50;
        amountOfChange = (double)ThreadLocalRandom.current().nextInt(-volatility, volatility+10);
        change = amountOfChange*price/1000;
        price = price + change;
    }
    
    /**
     * Fluctuates the stock price by a precentage of its previous price according to the business cycle.
     * 
     * @param businessCycle the business cycle of the stock market; 0 for full employment; -100 for recession; 100 for boom;
     */
    public void randomize(int businessCycle)
    {
        volatility = 50;
        amountOfChange = (double)ThreadLocalRandom.current().nextInt(-volatility, volatility+businessCycle);
        change = amountOfChange*price/1000;
        price = price + change;
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
        return round(price);
    }
    
    public String returnName() 
    {
        return name;
    }
    
    public double returnChange()
    {
        return round(change);
    }
    
    public double returnPercentageChange()
    {
        return round(amountOfChange/10);
    }

    public String toString()
    {
        String print = "";
        print += "Name: " + name + ", Price: $" + price + ", Available: " + available + ", Owned: " + owned + ".";
        return print;
    }
    
    public void printInfo()
    {
        String print = "";
        print += "Name: " + name + ", Price: $" + price + ", Change: $" + change + ", Index: " + index + ", Available: " + available + ", Owned: " + owned + ".";
        System.out.println(print);
    }
    
    public void printChange()
    {
        if(amountOfChange > 0)
        {
            System.out.println(name + " is up " + returnPercentageChange() + "% at $" + returnPrice() + " from $" + round(returnPrice() - returnChange()));
        }
        else if(amountOfChange < 0)
        {
            System.out.println(name + " is down " + returnPercentageChange() + "% at $" + returnPrice() + " from $" + round(returnPrice() - returnChange()));
        }
        else
        {
            System.out.println(name + " is constant at $" + returnPrice());
        }
    }
    
    
    private double round(double number)
    {
        number = Math.round(number * 100);
        number = number/100;
        return number;
    }
}
