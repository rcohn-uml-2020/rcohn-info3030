package edu.rcohn.advancedjava;

public class StockQuote {

    int value;

    StockQuote(String symbol) {
        this.value = symbol.length();
    }

    int getValue(){
        return value;
    }
}
