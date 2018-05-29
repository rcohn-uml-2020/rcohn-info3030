package com.rcohn-info3030

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Vehicle {
    // Vehicle components
    private string engine;
    private List<string> wheels;
    private string color;

    public Vehicle(string engine, List<string> wheels, string color ) {
        this.engine = engine;
        this.wheels = wheels;
        this.color = color;
    }
    // sets the color of the vehicle
    public void setColor(string color) {this.color = color;}
    // gets the color of the vehicle
    public string getColor() {
        return color;
    }
    // returns the numbers of elements in wheels list
    public int getWheelsNumber() {
        return wheels.size();
    }

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
