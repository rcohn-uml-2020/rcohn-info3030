package com.origamisoftware.teach.advanced.model;

/**
 * A container class that contains person data.
 */
public class Person {

    private String first_name;
    private String last_name;


    /**
     * Create a new instance of a Person.
     *
     * @param first_name the person's first name
     * @param last_name the person's last name
     */
    public Person(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    /**
     * @return Get the first name.
     */
    String getFirstName() {
        return first_name;
    }

    /**
     * @return Get the last name.
     */
    String getLastName() {
        return last_name;
    }

    /**
     * @return The full name.
     */
   
    @Override
    public String toString() {
        return "Person{" +
                "first name=" + first_name +
                ", last name=" + last_name +
                '}';
    }
}
