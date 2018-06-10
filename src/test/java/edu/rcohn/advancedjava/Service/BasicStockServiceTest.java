package edu.rcohn.advancedjava.Service;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
        assertEquals(BigDecimal.valueOf(84.99), basicStockService.getQuote("AAPL").getValue());
    }

    public void testGetQuoteNegative() {
        assertNotSame(BigDecimal.valueOf(0), basicStockService.getQuote("AAPL").getValue());
    }

    public void testGetQuoteListPositive(){
        assertEquals(BigDecimal.valueOf(84.99),basicStockService.getQuote("AAPL",(GregorianCalendar) Calendar.getInstance(), (GregorianCalendar) Calendar.getInstance()).get(0).getValue());
    }

    public void testGetQuoteListNegative(){
        assertNotSame(BigDecimal.valueOf(0),basicStockService.getQuote("AAPL",(GregorianCalendar) Calendar.getInstance(), (GregorianCalendar) Calendar.getInstance()).get(0).getValue());
    }

}
