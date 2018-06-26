package edu.rcohn.advancedjava.Model;

import java.util.Date;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * The class <code>StockQuote</code> contains the symbol for the stock, its price, and the date/time it was looked up.
 * @author rcohn
 * @version %I%, %G%
 */

public class StockQuote {

    private String symbol;
    private Date date;
    private BigDecimal value;

    /**
     * Creates a <code>StockQuote</code> by specifying the symbol and date. The value is currently predetermined.
     * @param symbol the stock symbol
     * @param day the date and time of the quote
     */

    public StockQuote(String symbol, Calendar day){
        this.symbol = symbol;
        this.date = day.getTime();
        this.value = BigDecimal.valueOf(84.99);
    }

    /**
     *
     * @return the set amount of the quote
     */

    public BigDecimal getValue() {
        return value;
    }

    /**
     *
     * @return a string representing the data in the <code>StockQuote</code>
     */

    @Override
    public String toString() {
        return symbol + " on " + date + ": $" + value + "\n";
    }
}
