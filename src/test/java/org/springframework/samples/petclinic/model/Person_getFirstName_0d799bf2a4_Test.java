package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class Person_getFirstName_0d799bf2a4_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetFirstNameWhenNameIsSet() {
        String expectedFirstName = "John";
        person.setFirstName(expectedFirstName);
        assertEquals(expectedFirstName, person.getFirstName());
    }

    @Test
    public void testGetFirstNameWhenNameIsNotSet() {
        String expectedFirstName = null;
        assertEquals(expectedFirstName, person.getFirstName());
    }
}
