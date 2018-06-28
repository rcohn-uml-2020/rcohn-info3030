package com.origamisoftware.teach.advanced.services;

import com.origamisoftware.teach.advanced.model.StockQuote;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest {

    @Test
    public void testGetQuote() throws Exception {
        DatabaseStockService databaseStockService = new DatabaseStockService();
        String symbol = "APPL";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }
	
	@Test
    public void testGetQuoteRange() throws Exception {
        DatabaseStockService databaseStockService = new DatabaseStockService();
        String symbol = "APPL";
		Calendar now = new GregorianCalendar();
		Calendar earlier = new GregorianCalendar();
		earlier.add(Calendar.YEAR,-10);
        List<StockQuote> stockQuoteList = databaseStockService.getQuote(symbol, earlier, now);
        assertNotNull("Verify we can get a stock quote from the db", stockQuoteList);
        for (StockQuote stockQuote : stockQuoteList) {
            assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
        }
    }
}
