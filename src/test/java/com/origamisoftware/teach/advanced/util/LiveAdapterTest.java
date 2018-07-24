package com.origamisoftware.teach.advanced.util;


import com.origamisoftware.teach.advanced.model.StockQuote;
import org.junit.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


/**
 *  Tests for the LiveAdapter class
 */
public class LiveAdapterTest {

    @Test
    public void testGetQuote() throws IOException, LiveException {
        assertThat(LiveAdapter.getStockQuote("AAPL").getSymbol(), is("AAPL"));
    }

    @Test
        public void testGetQuoteHistorical() throws IOException, LiveException {

        Calendar from = new GregorianCalendar();
        from.add(Calendar.MONTH, -1);

        Calendar until = new GregorianCalendar();

        List<StockQuote> historicalQuotes = LiveAdapter.getStockQuoteHistorical("AAPL", from, until);

        assertThat(historicalQuotes.get(0).getSymbol(), is("AAPL"));
    }
}
