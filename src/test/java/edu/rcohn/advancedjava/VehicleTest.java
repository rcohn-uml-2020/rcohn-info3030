package edu.rcohn.advancedjava;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class VehicleTest {

    private List<string> wheels;
    private String color;
    private Vehicle vehicle;

    @Before
    public void setup() {
        wheels = new List<string>;
        wheels.add("Front Left");
        wheels.add("Front Right");
        wheels.add("Back Left");
        this.color = "Blue";
        vehicle = new Vehicle(List<string> wheels, color);
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
