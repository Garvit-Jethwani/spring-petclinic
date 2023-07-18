package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.owner.Pet;

class PetValidator_supports_ba02a95e99_Test {

    @Test
    public void testSupports_ValidClass() {
        PetValidator petValidator = new PetValidator();
        boolean result = petValidator.supports(Pet.class);
        Assertions.assertTrue(result, "Expected true when a valid class is provided");
    }

    @Test
    public void testSupports_InvalidClass() {
        PetValidator petValidator = new PetValidator();
        boolean result = petValidator.supports(String.class);
        Assertions.assertFalse(result, "Expected false when an invalid class is provided");
    }
}
