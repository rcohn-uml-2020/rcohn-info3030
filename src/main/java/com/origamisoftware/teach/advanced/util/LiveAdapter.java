package com.origamisoftware.teach.advanced.util;

import com.origamisoftware.teach.advanced.model.StockQuote;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * A class that contains utility methods.
 */
public class LiveAdapter {

   public static StockQuote getStockQuote(String symbol) throws LiveException, IOException {

       try{
           YahooFinance.get(symbol);
       } catch (IOException e) {throw new LiveException("Not getting data from API", e);}

       Stock stock = YahooFinance.get(symbol);

       Date date = Calendar.getInstance().getTime();

       return new StockQuote(stock.getQuote().getPrice(), date, stock.getSymbol());}

    public static List<StockQuote> getStockQuoteHistorical(String symbol, Calendar from, Calendar until) throws LiveException, IOException {

       List<StockQuote> quotes = new ArrayList<>();

       try{
           YahooFinance.get(symbol, from, until);
       } catch (IOException e) {throw new LiveException("Not getting data from API", e);}

       for (HistoricalQuote h : YahooFinance.get(symbol, from, until).getHistory()){
           quotes.add(new StockQuote(h.getAdjClose(),h.getDate().getTime(), h.getSymbol()));
       }

       return quotes;
    }

}
