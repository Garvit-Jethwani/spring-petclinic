package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.Visit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_setDescription_5d6a2c2267_Test {

    private Visit visit;

    @BeforeEach
    public void setup() {
        visit = new Visit();
    }

    @Test
    public void testSetDescription_Success() {
        String description = "Checkup";
        visit.setDescription(description);
        assertEquals(description, visit.getDescription());
    }

    @Test
    public void testSetDescription_EmptyString() {
        String description = "";
        visit.setDescription(description);
        assertEquals(description, visit.getDescription());
    }

    @Test
    public void testSetDescription_Null() {
        String description = null;
        visit.setDescription(description);
        assertEquals(description, visit.getDescription());
    }
}
