
/**
 * Write a description of class Investor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Investor
{
    // instance variables - replace the example below with your own
    private double assets;
    private int numberOfStocks;
    Stock stock;
    private String name;
    
    /**
     * Constructor for objects of class Investor
     */
    public Investor()
    {
        // initialise instance variables
        assets = 1000;
        numberOfStocks = 0;
        stock = new Stock();
        name = "Warren Buffett";
    }

    /**
     * Constructor for objects of class Investor
     */
    public Investor(double assets)
    {
        // initialise instance variables
        this.assets = assets;
        this.numberOfStocks = 0;
        stock = new Stock();
        name = "Warren Buffett";
    }
    

    /**
     * Constructor for objects of class Investor
     */
    public Investor(double assets, double stockPrice)
    {
        // initialise instance variables
        this.assets = assets;
        this.numberOfStocks = 0;
        stock = new Stock(stockPrice);
        name = "Warren Buffett";
    }
    
    public Investor(double assets, double stockPrice, String name)
    {
        // initialise instance variables
        this.assets = assets;
        this.numberOfStocks = 0;
        stock = new Stock(stockPrice);
        this.name = name;
    }

    public String returnName()
    {
        return name;
    }
    
    /**
     * Returns the total of assets possesed in dollars.
     *
     * @return    the total of assets possesed
     */
    public double returnAssets()
    {
        // put your code here
        return assets + numberOfStocks*stock.returnPrice();
    }

    /**
     * Buy the number of stocks specified by the user.
     *
     * @param  number the number of stocks the user wishes to buy
     */
    public void buyStocks(int number)
    {
        if(assets >= number*stock.returnPrice())
        {
            this.numberOfStocks = numberOfStocks + number;
            this.assets = this.assets - number*stock.returnPrice();
        }
        else
        {
            System.out.println("Sorry, you need $" + (number*stock.returnPrice() - assets) + " more to complete the transaction.");
        }
    }

    /**
     * Sells the number of stocks specified by the user.
     *
     * @param  number the number of stocks the user wishes to sell
     */
    public void sellStocks(int number)
    {
        if(numberOfStocks >= number)
        {
            this.numberOfStocks = numberOfStocks - number;
            this.assets = this.assets + number*stock.returnPrice();
        }
        else
        {
            System.out.println("Sorry, you do not own enough stocks to complete the transaction.");
        }
    }

    /**
     * Passes the day and thereby allowing the stock price to fluctuate.
     *
     */
    public void passDay()
    {
        System.out.println("");
        System.out.println("Good morning, " + returnName() + "!");
        stock.randomize();
        forInfo();
    }

    /**
     * Provides information on the user's financial portfolio.
     */
    public void forInfo()
    {
        System.out.println("");
        System.out.println("Your total net worth is $" + round(returnAssets()) + ".");
        System.out.println("You have " + numberOfStocks + " stocks valued at $" + round(stock.returnPrice()) + ".");
        System.out.println("You possess $" + assets + " in financial capital and $" + round(numberOfStocks*stock.returnPrice()) + " in stocks.");
    }

    private void addStocks(int number)
    {
        this.numberOfStocks = numberOfStocks + number;
    }

    private void addAssets(double assets)
    {
        this.assets = this.assets + assets;
    }
    
    public double round(double number)
    {
        number = Math.round(number * 100);
        number = number/100;
        return number;
    }
}
