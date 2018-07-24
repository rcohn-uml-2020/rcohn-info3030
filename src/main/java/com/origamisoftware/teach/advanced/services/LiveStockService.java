package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.util.LiveException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.origamisoftware.teach.advanced.util.LiveAdapter.getStockQuote;
import static com.origamisoftware.teach.advanced.util.LiveAdapter.getStockQuoteHistorical;

/**
 * An implementation of the StockService interface that gets
 * stock data from a database.
 */
class LiveStockService implements StockService {

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {
        StockQuote stockQuote;

        BigDecimal price = null;

        try {
            price = getStockQuote(symbol).getPrice();
        } catch (IOException e) {} catch (LiveException e) {System.out.println(e.getMessage());}

        if (price == null) {
            throw new StockServiceException("Could not get a stock quote for: " + symbol);
        }

        Calendar calendar = Calendar.getInstance();
        Date quoteTime = calendar.getTime();
        stockQuote = new StockQuote(price, quoteTime, symbol);

        return stockQuote;
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol   the stock symbol to search for
     * @param from     the date of the first stock quote
     * @param until    the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until) throws StockServiceException {

        List<StockQuote> stockQuotes = null;

        try {
            stockQuotes = getStockQuoteHistorical(symbol,from,until);
        } catch (IOException e) {} catch (LiveException e) {System.out.println(e.getMessage());}

        return stockQuotes;
    }

}
