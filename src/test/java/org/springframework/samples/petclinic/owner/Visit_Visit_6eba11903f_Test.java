package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Visit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Visit_Visit_6eba11903f_Test {

    @Test
    public void testVisitDateToday() {
        Visit visit = new Visit();
        LocalDate expectedDate = LocalDate.now();
        assertEquals(expectedDate, visit.getDate());
    }

    @Test
    public void testVisitDateNotTomorrow() {
        Visit visit = new Visit();
        LocalDate notExpectedDate = LocalDate.now().plusDays(1);
        assertNotEquals(notExpectedDate, visit.getDate());
    }
}
