package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Pet_getBirthDate_edd397b024_Test {

    private Pet pet;

    @BeforeEach
    public void setUp() {
        pet = new Pet();
    }

    @Test
    public void testGetBirthDate_WhenBirthDateIsSet() {
        LocalDate expectedBirthDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(expectedBirthDate);

        LocalDate actualBirthDate = pet.getBirthDate();

        Assertions.assertEquals(expectedBirthDate, actualBirthDate, "The birth dates should match");
    }

    @Test
    public void testGetBirthDate_WhenBirthDateIsNotSet() {
        LocalDate actualBirthDate = pet.getBirthDate();

        Assertions.assertNull(actualBirthDate, "The birth date should be null as it's not set");
    }
}
