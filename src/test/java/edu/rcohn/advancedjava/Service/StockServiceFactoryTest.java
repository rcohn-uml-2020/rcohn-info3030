package edu.rcohn.advancedjava.Service;

import org.junit.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

/**
 * @author rcohn
 * @version %I%, %G%
 */

public class StockServiceFactoryTest {

    private StockServiceFactory factory;

    @Before
    public void setUp() {

        factory = new StockServiceFactory();
    }

    @Test
    public void testGetQuotePositive() {
        assertEquals(BigDecimal.valueOf(84.99), factory.create().getQuote("AAPL").getValue());
    }

    @Test
    public void testGetQuoteNegative() {
        assertNotSame(BigDecimal.valueOf(0),factory.create().getQuote("AAPL").getValue());
    }
}
