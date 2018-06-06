package edu.rcohn.advancedjava;

public class StockServiceFactory implements StockService {

    private StockQuote quote;

    StockServiceFactory() {
       this.quote = new StockQuote();
    }

    public StockQuote getQuote(String symbol){
        quote.setSymbol(symbol);
        return quote;
    }
}