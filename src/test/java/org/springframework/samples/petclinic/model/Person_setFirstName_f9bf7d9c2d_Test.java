package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_setFirstName_f9bf7d9c2d_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testSetFirstName_Success() {
        String firstName = "John";
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName(), "First name should be set correctly");
    }

    @Test
    public void testSetFirstName_Null() {
        person.setFirstName(null);
        assertEquals(null, person.getFirstName(), "First name should be null");
    }

    @Test
    public void testSetFirstName_Empty() {
        String firstName = "";
        person.setFirstName(firstName);
        assertEquals(firstName, person.getFirstName(), "First name should be empty");
    }
}
