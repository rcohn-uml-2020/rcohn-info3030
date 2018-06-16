package edu.rcohn.advancedjava;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author rcohn
 * @version %I%, %G%
 */

public class BasicStockServiceTest extends TestCase {
    /**
     * create the test case
     *
     * @param basicStockServiceTest name of the test case
     */
    public BasicStockServiceTest(String basicStockServiceTest)
    {
        super( basicStockServiceTest);
    }

    BasicStockService basicStockService;

    /**
     * @throws Exception
     */
    public void setUp() throws Exception {
        super.setUp();
        basicStockService = new BasicStockService();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( BasicStockServiceTest.class );
    }

    public void testGetQuotePositive() {
        assertEquals(0.0, basicStockService.getQuote("").getValue());
    }

    public void testGetQuoteNegative() {
        assertNotSame(1.0, basicStockService.getQuote("").getValue());
    }
}
