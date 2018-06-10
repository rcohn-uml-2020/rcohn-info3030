package edu.rcohn.advancedjava.Model;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 * @author rcohn
 * @version %I%, %G%
 */

public class StockQuoteTest extends TestCase {
    /**
     * create the test case
     *
     * @param StockQuoteTest name of the test case
     */
    public StockQuoteTest(String stockQuoteTest)
    {
        super( stockQuoteTest);
    }

    private StockQuote stockQuote;

    /**
     * @throws Exception
     */
    public void setUp() throws Exception {
        super.setUp();
        GregorianCalendar day = new GregorianCalendar();
        stockQuote = new StockQuote("AAPL", day);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StockQuoteTest.class );
    }

    public void testGetValuePositive() {
        assertEquals(BigDecimal.valueOf(84.99), stockQuote.getValue());
    }

    public void testGetValueNegative() {
        assertNotSame(BigDecimal.valueOf(0), stockQuote.getValue());
    }
}
