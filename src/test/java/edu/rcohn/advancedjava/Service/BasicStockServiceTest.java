/**
 * @author rcohn
 * @version %I%, %G%
 */

package edu.rcohn.advancedjava.Service;

import org.junit.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;


public class BasicStockServiceTest {

    private BasicStockService basicStockService;

    @Before
    public void setUp() {

        basicStockService = new BasicStockService();
    }

    @Test
    public void testGetQuotePositive() {
        assertEquals(BigDecimal.valueOf(84.99), basicStockService.getQuote("AAPL").getValue());
    }

    @Test
    public void testGetQuoteNegative() {
        assertNotSame(BigDecimal.valueOf(0), basicStockService.getQuote("AAPL").getValue());
    }

    @Test
    public void testGetQuoteListPositive(){
        assertEquals(BigDecimal.valueOf(84.99),basicStockService.getQuote("AAPL",Calendar.getInstance(), Calendar.getInstance()).get(0).getValue());
    }

    @Test
    public void testGetQuoteListNegative(){
        assertNotSame(BigDecimal.valueOf(0),basicStockService.getQuote("AAPL", Calendar.getInstance(), Calendar.getInstance()).get(0).getValue());
    }

}
