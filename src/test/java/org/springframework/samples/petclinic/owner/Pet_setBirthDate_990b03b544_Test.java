package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Pet_setBirthDate_990b03b544_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testSetBirthDateWithValidDate() {
        LocalDate birthDate = LocalDate.of(2020, 1, 1);
        pet.setBirthDate(birthDate);
        Assertions.assertEquals(birthDate, pet.getBirthDate());
    }

    @Test
    public void testSetBirthDateWithNullDate() {
        pet.setBirthDate(null);
        Assertions.assertNull(pet.getBirthDate());
    }

    @Test
    public void testSetBirthDateWithFutureDate() {
        LocalDate birthDate = LocalDate.now().plusDays(1);
        pet.setBirthDate(birthDate);
        Assertions.assertEquals(birthDate, pet.getBirthDate());
    }

    @Test
    public void testSetBirthDateWithPastDate() {
        LocalDate birthDate = LocalDate.now().minusDays(1);
        pet.setBirthDate(birthDate);
        Assertions.assertEquals(birthDate, pet.getBirthDate());
    }
}
