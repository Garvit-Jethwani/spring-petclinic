// Test regenerated by RoostGPT for test petclinic-springboot using AI Type Open AI and AI Model gpt-4

package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

public class Owner_setAddress_b094dc9d7e_Test {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
    }

    @Test
    public void testSetAddress() {
        String address = "123 Main St";
        person.setAddress(address);
        Assertions.assertEquals(address, person.getAddress());
    }

    @Test
    public void testSetAddress_Null() {
        String address = null;
        person.setAddress(address);
        Assertions.assertNull(person.getAddress());
    }

    @Test
    public void testSetAddress_Empty() {
        String address = "";
        person.setAddress(address);
        Assertions.assertEquals(address, person.getAddress());
    }
}
