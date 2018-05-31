package com.rcohn-info3030

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public interface StockService {
    /**
     * Return the current price for a share of stock for the given symbol
     * @param symbol the stock symbol of the company you want a quote for.
     * e.g. APPL for APPLE
     * @return a <CODE>StockQuote </CODE> instance
     */
    StockQuote getQuote(String symbol);
}

public class VehicleTest {

    private string engine;
    private List<string> wheels;
    private string color;
    private Vehicle vehicle;

    @Before
    public void setup() {
        engine = "Hot Rod";
        wheels = new List<string>;
        wheels.add("Front Left");
        wheels.add("Front Right");
        wheels.add("Back Left");
        color = "Blue";
        vehicle = new Vehicle(string engine, List<string> wheels, string color);
    }

    @Test
    public void testGetColorPositive() {
        assertTrue("Blue", vehicle.getColor());
    }

    // NOTICE: it is a good idea to write tests that verify expected behavior in both positive and negative ways.
    // ALSO NOTICE: I have separate tests for each specific test. Don't bunch up a tests into one test method.
    @Test
    public void testGetColorNegative() {
        vehicle.setColor("Red");
        assertFalse("Blue", vehicle.getColor());
    }

    @Test
    public void testGetWheelsNumberPositive() {
        assertTrue(3, vehicle.getWheelsNumber());
    }

    // NOTICE: it is a good idea to write tests that verify expected behavior in both positive and negative ways.
    // ALSO NOTICE: I have separate tests for each specific test. Don't bunch up a tests into one test method.
    @Test
    public void testGetWheelsNumberNegative() {
        assertFalse(4, vehicle.getWheelsNumber());
    }

}
