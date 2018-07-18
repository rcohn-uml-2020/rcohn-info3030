package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;

import com.origamisoftware.teach.advanced.util.LiveUtils;
import com.origamisoftware.teach.advanced.util.Interval;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.math.BigDecimal;

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

        BigDecimal quote = LiveUtils.getQuote(symbol).getPrice();

        if (quote.isNull()) {
            throw new StockServiceException("Could not find any stock quotes for: " + symbol);
        }

        Calendar calendar = Calendar.getInstance();
        Date quoteTime = calendar.getTime();
        stockQuote = new StockQuote(quote, quoteTime, symbol);

        return stockQuote;
    }

    /**
     * Returns true of the currentStockQuote has a date that is later by the time
     * specified in the interval value from the previousStockQuote time.
     *
     * @param endDate   the end time
     * @param interval  the period of time that must exist between previousStockQuote and currentStockQuote
     *                  in order for this method to return true.
     * @param startDate the starting date
     * @return
     */
    private boolean isInterval(java.util.Date endDate, Interval interval, java.util.Date startDate) {
        Calendar startDatePlusInterval = Calendar.getInstance();
        startDatePlusInterval.setTime(startDate);
        startDatePlusInterval.add(Calendar.MINUTE, interval.getMinutes());
        return endDate.after(startDatePlusInterval.getTime());
    }
}
