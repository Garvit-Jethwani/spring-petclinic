package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;

public class Owner_getPet_7f0beed2aa_Test {

    private Owner owner;
    private Pet pet;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        pet = mock(Pet.class);
        when(pet.getName()).thenReturn("Fido");
        when(pet.getType()).thenReturn(new PetType());
        owner.addPet(pet);
    }

    @Test
    public void testGetPet_success() {
        Pet actualPet = owner.getPet("Fido");
        assertEquals("Fido", actualPet.getName());
    }

    @Test
    public void testGetPet_failure() {
        Pet actualPet = owner.getPet("NotFido");
        assertNull(actualPet);
    }
}
