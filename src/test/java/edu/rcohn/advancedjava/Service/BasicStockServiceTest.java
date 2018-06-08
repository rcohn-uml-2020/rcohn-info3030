package edu.rcohn.advancedjava.Service;

import edu.rcohn.advancedjava.Service.BasicStockService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;

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

    private BasicStockService basicStockService;

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
        assertEquals(BigDecimal.valueOf(115.00), basicStockService.getQuote("AAPL").getValue());
    }

    public void testGetQuoteNegative() {
        assertNotSame(BigDecimal.valueOf(0.00), basicStockService.getQuote("AAPL").getValue());
    }
}
