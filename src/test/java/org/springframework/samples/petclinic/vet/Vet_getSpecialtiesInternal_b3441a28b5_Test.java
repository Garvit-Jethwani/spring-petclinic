package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Specialty;

public class Vet_getSpecialtiesInternal_b3441a28b5_Test {

    private Vet vet;

    @BeforeEach
    public void setup() {
        vet = new Vet();
    }

    @Test
    public void testGetSpecialtiesInternalWhenSpecialtiesIsNull() {
        Set<Specialty> specialties = vet.getSpecialtiesInternal();
        assertNotNull(specialties, "Specialties set should not be null");
        assertEquals(0, specialties.size(), "Specialties set should be empty");
    }

    @Test
    public void testGetSpecialtiesInternalWhenSpecialtiesIsNotNull() {
        Set<Specialty> testSpecialties = new HashSet<>();
        Specialty testSpecialty = new Specialty();
        testSpecialty.setName("Test Specialty");
        testSpecialties.add(testSpecialty);

        vet.setSpecialtiesInternal(testSpecialties);
        Set<Specialty> specialties = vet.getSpecialtiesInternal();

        assertNotNull(specialties, "Specialties set should not be null");
        assertEquals(1, specialties.size(), "Specialties set should contain 1 specialty");
        assertEquals(testSpecialty, specialties.iterator().next(), "Specialties set should contain the test specialty");
    }
}
