package edu.rcohn.advancedjava;

public class StockServiceFactory implements StockService {

    public StockQuote getQuote(String symbol) {
        return new StockQuote(symbol);
    }
}