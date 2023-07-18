package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;

public class Pet_getType_5e69a8c7da_Test {

    private Pet pet;

    @BeforeEach
    public void setup() {
        pet = new Pet();
    }

    @Test
    public void testGetType_Success() {
        PetType petType = mock(PetType.class);
        when(petType.getName()).thenReturn("Dog");

        pet.setType(petType);

        PetType actual = pet.getType();
        assertEquals(petType, actual);
    }

    @Test
    public void testGetType_Null() {
        PetType actual = pet.getType();
        assertEquals(null, actual);
    }
}
