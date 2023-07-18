package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Visit_setDate_a17e85b190_Test {

    private Visit visit;

    @BeforeEach
    public void setUp() {
        visit = new Visit();
    }

    @Test
    public void testSetDateWithValidDate() {
        LocalDate testDate = LocalDate.of(2022, 12, 31);
        visit.setDate(testDate);
        assertEquals(testDate, visit.getDate(), "The date should be set correctly");
    }

    @Test
    public void testSetDateWithNullDate() {
        visit.setDate(null);
        assertEquals(null, visit.getDate(), "The date should be null");
    }
}
