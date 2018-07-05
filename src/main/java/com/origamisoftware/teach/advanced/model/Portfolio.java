package com.origamisoftware.teach.advanced.model;

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
     * @param symbols the person's watched stock symbols
     */
    public Portfolio (String name) {
        this.name = name;
        this.symbols = new ArrayList<String>;
    }

    /**
     * @return Get the name of the person.
     */
    String getName() {
        return name;
    }

    /**
     * @return Get the symbols.
     */
    String getSymbols() {
        return symbols;
    }

    /**
     * @return The name and list of symbols.
     */
   
    @Override
    Stringbuilder symbols = new Stringbuilder;
    for (symbol:symbols){
    symbols += symbol + " ";
    }
    public String toString() {
        return "Portfolio{" +
                "name=" + name +
                ", symbols=" + symbols +
                '}';
    }
}
