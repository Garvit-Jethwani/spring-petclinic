package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;
import java.util.Collection;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Pet_getVisits_6fe3ce5852_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetVisits_whenNoVisits() {
        Collection<Visit> visits = pet.getVisits();
        assertTrue(visits.isEmpty(), "Visits should be empty as no visits are added yet.");
    }

    @Test
    public void testGetVisits_whenVisitsExist() {
        Collection<Visit> testVisits = new LinkedList<>();
        Visit visit1 = new Visit();
        visit1.setDescription("Visit 1");
        testVisits.add(visit1);

        Visit visit2 = new Visit();
        visit2.setDescription("Visit 2");
        testVisits.add(visit2);

        pet.setVisitsInternal(testVisits);
        Collection<Visit> visits = pet.getVisits();

        assertEquals(testVisits, visits, "Visits should match the visits added.");
    }
}
