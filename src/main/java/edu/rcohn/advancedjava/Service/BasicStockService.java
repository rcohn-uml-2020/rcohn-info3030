
package edu.rcohn.advancedjava.Service;

import edu.rcohn.advancedjava.Model.StockQuote;

import java.util.*;

public class BasicStockService implements StockService {

    private static Calendar day;

    public BasicStockService(){
        this.day = new GregorianCalendar();
    }

    public StockQuote getQuote(String symbol){

        return new StockQuote(symbol, day);
    }

    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {

            List<StockQuote> quoteList = new ArrayList<>();

            Calendar current;
            do {
            current = from;

            StockQuote quote = new StockQuote(symbol, current);

            quoteList.add(quote);

            current.add(Calendar.DAY_OF_MONTH, 1);

        } while (!(current.compareTo(until) > 0));

        return quoteList;
    }

    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) {

        List<StockQuote> quoteList = new ArrayList<>();

        Calendar current;
        do {
            current = from;

            StockQuote quote = new StockQuote(symbol, current);

            quoteList.add(quote);

            switch (interval) {

                case DAY: current.add(Calendar.DAY_OF_MONTH, 1);
                            break;

                case WEEK: current.add(Calendar.DAY_OF_MONTH, 7);
                            break;

                case MONTH: current.add(Calendar.MONTH, 1);
                            break;

                case QUARTER: current.add(Calendar.MONTH, 3);
                            break;

                case YEAR: current.add(Calendar.YEAR, 1);
                            break;

                case DECADE: current.add(Calendar.YEAR, 10);
                            break;

                default: current.add(Calendar.DAY_OF_MONTH, 1);
                            break;
            }

        } while (!(current.compareTo(until) > 0));

        return quoteList;
    }
}