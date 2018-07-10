package com.origamisoftware.teach.advanced.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A container class that contains stock data.
 */

@Entity
@Table(name="portfolio")
public class MyStock {

    @Id @Column(name="id") private int id;
    @Column(name="person_id") private int person_id;
    @Column(name="quotes_id") private int quotes_id;


    /**
     * Create a new instance of a stock.
     *
     * @param id primary data id
     * @param person_id the person's name
     * @param quotes_id the symbol of the stock used in the quotes database
     */
    public MyStock (int id, int person_id, int quotes_id) {
        this.id = id;
        this.person_id = person_id;
        this.quotes_id = quotes_id;
    }

    /**
     * @return Get the name of the person.
     */
    int getPerson_id() {
        return person_id;
    }

    /**
     * @return Get the symbols.
     */
    int getQuotes_id() {
        return quotes_id;
    }

    /**
     * @return The name and list of symbols.
     */
   
    @Override
    public String toString() {

        return "MyStock{" +
                "id=" + id +
                "person_id=" + person_id +
                ", symbols=" + quotes_id +
                '}';
    }
}
