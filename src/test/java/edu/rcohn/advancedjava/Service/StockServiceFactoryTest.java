package edu.rcohn.advancedjava.Service;

import edu.rcohn.advancedjava.Service.StockServiceFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;

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

    private StockServiceFactory factory;

    /**
     * @throws Exception
     */
    public void setUp() throws Exception {
        super.setUp();
        factory = new StockServiceFactory();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( StockServiceFactoryTest.class );
    }

    public void testGetQuotePositive() {
        assertEquals(BigDecimal.valueOf(84.99), factory.create().getQuote("AAPL").getValue());
    }

    public void testGetQuoteNegative() {
        assertNotSame(BigDecimal.valueOf(0),factory.create().getQuote("AAPL").getValue());
    }
}
