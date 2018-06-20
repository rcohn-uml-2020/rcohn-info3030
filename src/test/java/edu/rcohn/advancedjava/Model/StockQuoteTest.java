/**
 * @author rcohn
 * @version %I%, %G%
 */

package edu.rcohn.advancedjava.Model;

import org.junit.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.*;



public class StockQuoteTest {

    private StockQuote stockQuote;

    @Before
    public void setUp() {
        Calendar day = new GregorianCalendar();
        stockQuote = new StockQuote("AAPL", day);
    }

    @Test
    public void testGetValuePositive() {
        assertEquals(BigDecimal.valueOf(84.99), stockQuote.getValue());
    }

    @Test
    public void testGetValueNegative() {
        assertNotSame(BigDecimal.valueOf(0), stockQuote.getValue());
    }
}
