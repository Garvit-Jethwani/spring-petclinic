package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.samples.petclinic.owner.PetController;
import org.springframework.samples.petclinic.owner.PetType;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PetController_populatePetTypes_4b0826342f_Test {

    @InjectMocks
    PetController petController;

    @Mock
    OwnerRepository owners;

    @Before
    public void setup() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        cat.setName("Cat");

        List<PetType> petTypes = Arrays.asList(dog, cat);

        when(owners.findPetTypes()).thenReturn(petTypes);
    }

    @Test
    public void testPopulatePetTypes_Success() {
        Collection<PetType> petTypes = petController.populatePetTypes();
        assertEquals(2, petTypes.size());
    }

    @Test
    public void testPopulatePetTypes_Failure() {
        when(owners.findPetTypes()).thenReturn(null);
        Collection<PetType> petTypes = petController.populatePetTypes();
        assertEquals(0, petTypes.size());
    }
}
