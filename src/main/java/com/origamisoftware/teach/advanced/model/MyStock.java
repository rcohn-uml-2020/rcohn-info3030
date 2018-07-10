package com.origamisoftware.teach.advanced.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * A container class that contains stock data.
 */

@Entity
@Table(name="MyStock")
public class MyStock {

    @Id @Column(name="id") private int id;
    @Column(name="person_id") private int person_id;
    @Column(name="symbol_id") private int symbol_id;


    /**
     * Create a new instance of a stock.
     *
     * @param id
     * @param person_id the person's name
     * @param symbol_id the symbol of the stock
     */
    public MyStock (int id, int person_id, int symbol_id) {
        this.id = id;
        this.person_id = person_id;
        this.symbol_id = symbol_id;
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
