package edu.rcohn.advancedjava.Service;

public class StockServiceFactory {

        StockService create() {return new BasicStockService(); }
}
