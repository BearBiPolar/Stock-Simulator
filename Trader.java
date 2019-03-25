
/**
 * Write a description of class Trader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Trader
{
    // instance variables - replace the example below with your own
    private int x;
    Stock stock;
    Investor investor;

    /**
     * Constructor for objects of class Trader
     */
    public Trader()
    {
        // initialise instance variables
        investor = new Investor();
        stock = new Stock();
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
        investor.buyStocks(y);
    }

    public void sellStock(int y)
    {
        investor.sellStocks(y);
    }
    
    /**
     * Passes the day and thereby allowing the stock price to fluctuate.
     *
     */
    public void passDay()
    {
        System.out.println("");
        System.out.println("Good morning, " + investor.returnName() + "!");
        stock.randomize();
        investor.getInfo();
    }
}
