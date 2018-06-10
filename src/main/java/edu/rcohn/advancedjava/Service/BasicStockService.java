
package edu.rcohn.advancedjava.Service;

import edu.rcohn.advancedjava.Model.StockQuote;

import java.util.*;

public class BasicStockService implements StockService {

    private static GregorianCalendar day;

    public BasicStockService(){
        this.day = new GregorianCalendar();
    }

    public StockQuote getQuote(String symbol){

        return new StockQuote(symbol, day);
    }

    public List<StockQuote> getQuote(String symbol, GregorianCalendar from, GregorianCalendar until) {

        List<StockQuote> quoteList = new ArrayList<>();

        until.add(Calendar.DAY_OF_MONTH, 1);

        GregorianCalendar current;
        do {
            current = from;

            StockQuote quote = new StockQuote(symbol, current);

            quoteList.add(quote);

            current.add(Calendar.DAY_OF_MONTH, 1);

        } while (!(current.equals(until)));

        return quoteList;
    }
}