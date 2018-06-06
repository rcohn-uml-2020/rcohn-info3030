
package edu.rcohn.advancedjava;

public class BasicStockService implements StockService {

    final StockQuote quote;

    BasicStockService() {
        this.quote = new StockQuote();
    }

    public StockQuote getQuote(String symbol){
        return quote;
    }
}