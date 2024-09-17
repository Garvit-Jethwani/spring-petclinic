package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.Visit;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class Owner_addVisit_e85a2eeaa5_Test {

    @InjectMocks
    Owner owner;

    @Mock
    Pet pet;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddVisitWithValidPetIdAndVisit() {
        Visit visit = new Visit();
        when(owner.getPet(1)).thenReturn(pet);
        owner.addVisit(1, visit);
        verify(pet, times(1)).addVisit(visit);
    }

    @Test
    public void testAddVisitWithInvalidPetId() {
        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(null, new Visit()));
    }

    @Test
    public void testAddVisitWithInvalidVisit() {
        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(1, null));
    }

    @Test
    public void testAddVisitWithInvalidPetIdAndVisit() {
        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(null, null));
    }

    @Test
    public void testAddVisitWithNonExistentPetId() {
        when(owner.getPet(1)).thenReturn(null);
        assertThrows(IllegalArgumentException.class, () -> owner.addVisit(1, new Visit()));
    }
}
