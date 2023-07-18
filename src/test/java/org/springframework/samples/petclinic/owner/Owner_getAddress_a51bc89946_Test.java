package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.*;

public class Owner_getAddress_a51bc89946_Test {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
    }

    @Test
    public void testGetAddress() {
        String expectedAddress = "123 Main St";
        person.setAddress(expectedAddress);
        String actualAddress = person.getAddress();
        assertEquals(expectedAddress, actualAddress, "Address should match the set value");
    }

    @Test
    public void testGetAddress_Null() {
        String expectedAddress = null;
        person.setAddress(expectedAddress);
        String actualAddress = person.getAddress();
        assertNull(actualAddress, "Address should be null");
    }
}
