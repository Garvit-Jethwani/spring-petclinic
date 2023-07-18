package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_getDescription_ca387c4bd2_Test {

    private Visit visit;

    @BeforeEach
    public void setUp() {
        visit = new Visit();
    }

    @Test
    public void testGetDescription_WithDescriptionSet() {
        String expectedDescription = "Test Description";
        visit.setDescription(expectedDescription);
        String actualDescription = visit.getDescription();
        assertEquals(expectedDescription, actualDescription, "Expected and actual descriptions should match");
    }

    @Test
    public void testGetDescription_WithoutDescriptionSet() {
        String actualDescription = visit.getDescription();
        assertEquals(null, actualDescription, "Description should be null as it is not set");
    }
}
