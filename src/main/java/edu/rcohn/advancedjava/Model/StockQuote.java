package edu.rcohn.advancedjava.Model;

import java.util.Date;

import java.math.BigDecimal;
import java.util.Calendar;

public class StockQuote {

    private String symbol;
    private Date date;
    private BigDecimal value;

    public StockQuote(String symbol, Calendar day){
        this.symbol = symbol;
        this.date = day.getTime();
        this.value = BigDecimal.valueOf(84.99);
    }

    public BigDecimal getValue() {
        return value;
    }

    @Override
    public String toString() {
        return symbol + " on " + date + ": $" + value + "\n";
    }
}
