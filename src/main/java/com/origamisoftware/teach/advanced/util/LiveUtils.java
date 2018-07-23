package com.origamisoftware.teach.advanced.util;

import com.origamisoftware.teach.advanced.model.StockQuote;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.GregorianCalendar;

import static java.math.BigDecimal.valueOf;

/**
 * A class that contains utility methods.
 */
public class LiveUtils {

   public static StockQuote getQuote (String symbol) throws IOException {
       try {
           Stock stock = YahooFinance.get(symbol);
       } catch (IOException e) {

       }

       return new StockQuote(valueOf(0.00), new GregorianCalendar().getTime(), symbol);}



}
