package edu.rcohn.advancedjava;

public class StockQuote {

    private String symbol;

    StockQuote(){
        this.symbol = "";
    }

    void setSymbol(String symbol){
        this.symbol = symbol;
    }

    double getValue(){
        double value = 0.0;
        int i = 0;
        int len = symbol.length();

        while (i < len) {

            value += 0.25 * symbol.charAt(i);
            i++;
        }

        return value;
    }
}
