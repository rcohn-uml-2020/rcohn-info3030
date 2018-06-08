
package edu.rcohn.advancedjava.Service;

import edu.rcohn.advancedjava.Model.StockQuote;

import java.util.GregorianCalendar;
import java.util.Date;

public class BasicStockService implements StockService {

    private static Date date;

    public BasicStockService(){
        this.date = new GregorianCalendar().getTime();
    }

    public StockQuote getQuote(String symbol){

        return new StockQuote(symbol, date);
    }
}