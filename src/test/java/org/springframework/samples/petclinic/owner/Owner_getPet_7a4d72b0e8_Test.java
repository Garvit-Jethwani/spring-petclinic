package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Owner_getPet_7a4d72b0e8_Test {

    private Owner owner;

    @BeforeEach
    public void setUp() {
        this.owner = new Owner();
        Pet pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("Fido");
        Pet pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("Rex");
        this.owner.addPet(pet1);
        this.owner.addPet(pet2);
    }

    @Test
    public void testGetPet_withExistingId() {
        Pet pet = this.owner.getPet(1);
        assertEquals("Fido", pet.getName());
    }

    @Test
    public void testGetPet_withNonExistingId() {
        Pet pet = this.owner.getPet(3);
        assertNull(pet);
    }
}
