package edu.rcohn.advancedjava.Test;

import java.util.List;

/**
 * @author rcohn
 * @version %I%, %G%
 *
 */

public class Vehicle {
    // Vehicle components
    private List<String> wheels;
    private String color;

    /**
     *
     * @param wheels list containing wheels
     * @param color color of vehicle
     */

    public Vehicle(List<String> wheels, String color ) {
        this.wheels = wheels;
        this.color = color;
    }

    /**
     *
     * @param color color of vehicle
     */

    public void setColor(String color) {this.color = color;}

    /**
     *
     * @return color of vehicle
     */

    public String getColor() {
        return color;
    }

    /**
     *
     * @param wheels list containing wheels
     */

    public void setWheels(List<String> wheels) {
        this.wheels = wheels;
    }

    /**
     *
     * @return number of wheels
     */

    // returns the numbers of elements in wheels list
    public int getWheelsNumber() { return wheels.size();}

}