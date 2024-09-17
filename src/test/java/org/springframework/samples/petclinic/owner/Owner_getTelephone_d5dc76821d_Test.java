package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Owner_getTelephone_d5dc76821d_Test {
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetTelephone_WhenTelephoneIsSet() {
        String expectedTelephone = "123-456-7890";
        person.setTelephone(expectedTelephone);
        String actualTelephone = person.getTelephone();
        assertEquals(expectedTelephone, actualTelephone, "Telephone returned should be the same as the one set");
    }

    @Test
    public void testGetTelephone_WhenTelephoneIsNotSet() {
        String actualTelephone = person.getTelephone();
        assertNull(actualTelephone, "Telephone returned should be null when not set");
    }
}
