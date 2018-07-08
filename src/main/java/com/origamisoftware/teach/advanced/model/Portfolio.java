package com.origamisoftware.teach.advanced.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A container class that contains portfolio data.
 */
public class Portfolio {

    private String person;
    private List<String> symbols;


    /**
     * Create a new instance of a Portfolio.
     *
     * @param person the person's name
     */
    public Portfolio (String person) {
        this.person = person;
        this.symbols = new ArrayList<String>();
    }

    /**
     * @return Get the name of the person.
     */
    String getName() {
        return person;
    }

    /**
     * @return Get the symbols.
     */
    List<String> getSymbols() {
        return symbols;
    }

    /**
     * @return The name and list of symbols.
     */
   
    @Override
    public String toString() {
        StringBuilder symbolsBuilder = new StringBuilder();
        for (String symbol:symbols)
            symbolsBuilder.append(symbol).append(", ");

        return "Portfolio{" +
                "person=" + person +
                ", symbols=" + symbols +
                '}';
    }
}
