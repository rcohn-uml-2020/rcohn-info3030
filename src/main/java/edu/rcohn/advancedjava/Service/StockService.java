package edu.rcohn.advancedjava.Service;

import edu.rcohn.advancedjava.Model.StockQuote;

public interface StockService {

    StockQuote getQuote(String symbol);
}
