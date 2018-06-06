package edu.rcohn.advancedjava;

public class StockServiceFactory implements StockService {

    private final StockQuote quote;

    public static class Builder {

        private final StockQuote quote;

        public Builder(){
            this.quote = new StockQuote();
        }

        public StockService build(){

            return new StockServiceFactory (this);
        }
    }

    private StockServiceFactory(Builder builder) {
        quote = builder.quote;
    }

    public StockQuote getQuote(String symbol) {
        quote.setSymbol(symbol);
        return quote;
    }
}
