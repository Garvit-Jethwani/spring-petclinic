package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Person_getLastName_de1cc748dc_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetLastNameWhenLastNameIsSet() {
        String expectedLastName = "Smith";
        person.setLastName(expectedLastName);
        String actualLastName = person.getLastName();
        assertEquals(expectedLastName, actualLastName, "Expected and actual last name do not match");
    }

    @Test
    public void testGetLastNameWhenLastNameIsNotSet() {
        String expectedLastName = null;
        String actualLastName = person.getLastName();
        assertEquals(expectedLastName, actualLastName, "Expected null but got a value");
    }
}
