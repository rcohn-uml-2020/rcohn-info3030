package edu.rcohn.advancedjava;

public class BasicStockService implements StockService {
    public StockQuote getQuote(String basic){
        return new StockQuote("");
    }
}
