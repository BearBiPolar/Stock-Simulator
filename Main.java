
import java.io.*;
import java.util.*;
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Main
{
    public static void main(String[] args) {
        // Exchange exchange = new Exchange();
        Investor investor = new Investor();
        for(int i = 0; i < investor.getNumberOfStocks(); i++)
        {
            investor.buyStock(i, 1);
        }
        System.out.println("start");
        investor.news();
        System.out.println("end");
        investor.newDay();
    }
}
