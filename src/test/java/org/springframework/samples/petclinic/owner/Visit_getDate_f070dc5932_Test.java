package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.visit.Visit;

public class Visit_getDate_f070dc5932_Test {

    private Visit visit;

    @BeforeEach
    public void setUp() {
        visit = new Visit();
    }

    @Test
    public void testGetDateSuccess() {
        LocalDate expectedDate = LocalDate.of(2022, 1, 1);
        visit.setDate(expectedDate);
        LocalDate actualDate = visit.getDate();
        Assertions.assertEquals(expectedDate, actualDate, "The date should match the set date");
    }

    @Test
    public void testGetDateNull() {
        LocalDate actualDate = visit.getDate();
        Assertions.assertNull(actualDate, "The date should be null as it has not been set");
    }
}
