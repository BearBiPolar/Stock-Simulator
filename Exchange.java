import java.util.*;
/**
 * Write a description of class Exchange here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Exchange
{
    // instance variables - replace the example below with your own
    private int[] available = {10000, 1000, 100, 10, 1};
    private String[] names = {"AAPL", "AMZN", "JD", "ROKU", "SIRI"};
    private double[] prices = {188.74, 1778.37, 28.39, 66.75, 5.74};
    private int numberOfStocks = 5;
    private int businessCycle = 10;
    private int day = 1;
    ArrayList <Stock> stocks = new ArrayList<Stock>();
    
    
    /**
     * Constructor for objects of class Exchange
     */
    public Exchange()
    {
        // initialise instance variables
        for(int i = 0; i < numberOfStocks; i++)
        {
            Stock stock = new Stock(available[i], i, names[i], prices[i]);
            stocks.add(stock);
        }
    }
    
    public void buyStock(int index, int number)
    {
        Stock stock = stocks.get(index);
        stock.buyStock(number);
    }
    
    public void sellStock(int index, int number)
    {
        Stock stock = stocks.get(index);
        stock.sellStock(number);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double returnAssets()
    {
        // put your code here
        double total = 0;
        for(int i = 0; i < numberOfStocks; i++)
        {
            Stock stock = stocks.get(i);
            total += stock.returnOwned() * stock.returnPrice();
        }
        return total;
    }
    
    public void newDay()
    {
        day++;
        for(int i = 0; i < numberOfStocks; i++)
        {
            stocks.get(i).randomize();
        }
        news();
    }
    
    public void newDay(int businessCycle)
    {
        day++;
        for(int i = 0; i < numberOfStocks; i++)
        {
            stocks.get(i).randomize(businessCycle);
            stocks.get(i).printInfo();
        }
    }
    
    public void news()
    {
        System.out.println("");
        System.out.println("Today is your Day #" + day + " of stock trading!");
        System.out.println("");
        System.out.println("The Stock Market net % change is: " + returnOverview() + "%.");
        System.out.println("");
        System.out.println("Here are the updates: ");
        for(int i = 0; i < numberOfStocks; i++)
        {
            stocks.get(i).printChange();
        }
        returnAssetOverview();
    }
    
    private void returnAssetOverview()
    {
        System.out.println("");
        System.out.println("Portfolio:");
        for(int i = 0; i < numberOfStocks; i++)
        {
            Stock stock = stocks.get(i);
            System.out.println("You own " + stock.returnOwned() + " stocks of " + stock.returnName() + " valued at $" + stock.returnPrice() + "; valued at $" + stock.returnPrice()*stock.returnOwned());
            
        }
        System.out.println("Total Investment Value: $" + returnAssets());
        System.out.println("Total Market Value: $" + returnAssets());
    }
    
    private double returnOverview()
    {
        double total = 0;
        for(int i = 0; i < numberOfStocks; i++)
        {
            total += stocks.get(i).returnPercentageChange();
        }
        int percent = (int)total*100/numberOfStocks;
        return percent/100;
    }
}
