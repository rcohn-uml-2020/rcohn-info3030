package edu.rcohn.advancedjava.Model;

import java.util.Date;

import java.math.BigDecimal;

public class StockQuote {

    private String symbol;
    private Date date;
    private BigDecimal value;

    public StockQuote(String symbol, Date date){
        this.symbol = symbol;
        this.date = date;
        this.value = BigDecimal.valueOf(115.00);
    }

    public BigDecimal getValue() {
        return value;
    }
}
