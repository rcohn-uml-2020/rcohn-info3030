package com.origamisoftware.teach.advanced.apps.stockquote;

import com.origamisoftware.teach.advanced.model.StockQuery;
import com.origamisoftware.teach.advanced.model.StockQuote;
import com.origamisoftware.teach.advanced.services.StockService;
import com.origamisoftware.teach.advanced.services.StockServiceException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Tests for BasicStockQuoteApplication
 */
public class BasicStockQuoteApplicationTest {

    private BasicStockQuoteApplication basicStockQuoteApplication;
    private StockService stockServiceMock;

    @Before
    public void setUp() {
        stockServiceMock = mock(StockService.class);
    }

    @Test
    public void testValidConstruction() {
        basicStockQuoteApplication = new BasicStockQuoteApplication(stockServiceMock);
        assertNotNull("Basic construction works");
    }

    @Test
    public void testDisplayResults() throws ParseException, StockServiceException {
        basicStockQuoteApplication = new BasicStockQuoteApplication(stockServiceMock);
        String symbol = "AAPL";
        String from = "2011-10-29 12:12:12";    //yyyy-MM-dd HH:mm:ss
        String until = "2014-11-29 12:12:12";
        StockQuery stockQuery = new StockQuery(symbol, from, until);

        List<StockQuote> stockQuotes = new ArrayList<>();
        StockQuote stockQuoteFromDate = new StockQuote(new BigDecimal(100), stockQuery.getFrom().getTime(), stockQuery.getSymbol());
        stockQuotes.add(stockQuoteFromDate);
        StockQuote stockQuoteUntilDate = new StockQuote(new BigDecimal(100), stockQuery.getUntil().getTime(), stockQuery.getSymbol());
        stockQuotes.add(stockQuoteUntilDate);

        when(stockServiceMock.getQuote(
                any(String.class),
                any(Calendar.class),
                any(Calendar.class)))
                .thenReturn(stockQuotes);

        String output = basicStockQuoteApplication.displayStockQuotes(stockQuery);
        System.out.println(output);
        assertThat("symbol appears in output", output.contains(symbol), is(true));
        assertThat("from date appears in output", output.contains(from), is(true));
        assertThat("until date appears in output", output.contains(until), is(true));

    }

    @Test(expected = NullPointerException.class)
    public void testMainNegative() {
        BasicStockQuoteApplication.main(null);
    }
}
