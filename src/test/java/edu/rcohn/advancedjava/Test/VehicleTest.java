package edu.rcohn.advancedjava.Test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.*;

/**
 * @author rcohn
 * @version %I%, %G%
 */
public class VehicleTest extends TestCase {

    /**
     * Create the test case
     *
     * @param vehicleTest name of the test case
     */
    public VehicleTest( String vehicleTest )
    {
        super( vehicleTest );
    }

    private List<String> wheels;
    private String color;
    private Vehicle vehicle;

    /**
     *
     * @throws Exception
     */

    public void setUp() throws Exception {
        super.setUp();
        wheels = new ArrayList<String>();
        color = "";
        vehicle = new Vehicle(wheels, color);
        vehicle.setColor("Blue");
        wheels.add("Front Left");
        wheels.add("Front Right");
        wheels.add("Back Left");
        vehicle.setWheels(wheels);

    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( VehicleTest.class );
    }

    public void testGetColorPositive() {
        assertEquals("Blue", vehicle.getColor());
    }

    // NOTICE: it is a good idea to write tests that verify expected behavior in both positive and negative ways.
    // ALSO NOTICE: I have separate tests for each specific test. Don't bunch up a tests into one test method.
    public void testGetColorNegative() {
        assertNotSame("Red", vehicle.getColor());
    }

    public void testGetWheelsNumberPositive() {
        assertEquals(3, vehicle.getWheelsNumber());
    }

    public void testGetWheelsNumberNegative() {
        assertNotSame( 4, vehicle.getWheelsNumber());
    }
}
