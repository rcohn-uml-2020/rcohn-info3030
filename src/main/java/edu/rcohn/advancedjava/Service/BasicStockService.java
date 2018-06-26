/**
 * @author rcohn
 * @version %I%, %G%
 */

package edu.rcohn.advancedjava.Service;

import edu.rcohn.advancedjava.Model.StockQuote;

import java.util.*;

/**
 * <code>BasicStockService</code> is a basic implementation of the <code>StockService</code> interface
 */

public class BasicStockService implements StockService {

    private static Calendar day;

    /**
     *  Creates a <code>BasicStockService</code> containing today's date.
     */

    public BasicStockService(){
        this.day = new GregorianCalendar();
    }

    /**
     *
     * @param symbol the stock symbol of the company you want a quote for e.g. APPL for APPLE
     * @return a new <code>StockQuote</code> for that symbol with same date and time as the BasicStockService
     */

    public StockQuote getQuote(String symbol){

        return new StockQuote(symbol, day);
    }

    /**
     *
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @return an array of quotes that match these values
     */


    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) {

            List<StockQuote> quoteList = new ArrayList<StockQuote>();

            Calendar current;
            do {
            current = from;

            StockQuote quote = new StockQuote(symbol, current);

            quoteList.add(quote);

            current.add(Calendar.DAY_OF_MONTH, 1);

        } while (!(current.compareTo(until) > 0));

        return quoteList;
    }

    /**
     *
     * @param symbol the stock symbol to search for
     * @param from the date of the first stock quote
     * @param until the date of the last stock quote
     * @param interval ­ the number of StockQuotes to get. E.g. if Interval.DAILY was
     * specified one StockQuote per day will be returned.
     * @return an array of quotes that match these values
     */

    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, Interval interval) {

        List<StockQuote> quoteList = new ArrayList<StockQuote>();

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