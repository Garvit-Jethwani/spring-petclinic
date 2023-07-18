package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class Owner_addPet_8df3885a5e_Test {

    @InjectMocks
    private Owner owner;

    @Mock
    private Pet pet;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPetWhenPetIsNew() {
        when(pet.isNew()).thenReturn(true);

        owner.addPet(pet);

        verify(pet, times(1)).isNew();
        assertTrue(owner.getPets().contains(pet));
    }

    @Test
    public void testAddPetWhenPetIsNotNew() {
        when(pet.isNew()).thenReturn(false);

        owner.addPet(pet);

        verify(pet, times(1)).isNew();
        assertFalse(owner.getPets().contains(pet));
    }
}
