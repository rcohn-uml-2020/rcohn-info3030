package edu.rcohn.advancedjava;

public class StockServiceFactory implements StockService {

    private final String symbol;
    private final StockQuote quote;

    public static class Builder {
        private final String symbol;
        private final StockQuote quote;

        public Builder(String symbol) {
            this.symbol = symbol;
            this.quote = new StockQuote();
        }

        public StockService build() {
            return new StockServiceFactory(this);
        }
    }

    private StockServiceFactory(Builder builder) {
        symbol = builder.symbol;
        quote = builder.quote;
    }

    public StockQuote getQuote() {
        return quote;
    }
}
