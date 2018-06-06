package edu.rcohn.advancedjava;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
        stockQuote = new StockQuote();
        stockQuote.setSymbol("AAPL");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StockQuoteTest.class );
    }

    public void testGetValuePositive() {
        assertEquals(71.5, stockQuote.getValue());
    }

    public void testGetValueNegative() {
        assertNotSame(0.0, stockQuote.getValue());
    }
}
