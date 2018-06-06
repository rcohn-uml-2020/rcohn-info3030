package edu.rcohn.advancedjava;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author rcohn
 * @version %I%, %G%
 */

public class StockServiceFactoryTest extends TestCase {
    /**
     * create the test case
     *
     * @param stockServiceFactoryTest name of the test case
     */
    public StockServiceFactoryTest(String stockServiceFactoryTest)
    {
        super( stockServiceFactoryTest);
    }

    StockService stockService;

    /**
     * @throws Exception
     */
    public void setUp() throws Exception {
        super.setUp();
        stockService = new StockServiceFactory.Builder("AAPL").build();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StockServiceFactoryTest.class );
    }

    public void testGetQuotePositive() {
        assertEquals(71.5, stockService.getQuote().getValue());
    }

    public void testGetQuoteNegative() {
        assertNotSame(0.0, stockService.getQuote().getValue());
    }
}
