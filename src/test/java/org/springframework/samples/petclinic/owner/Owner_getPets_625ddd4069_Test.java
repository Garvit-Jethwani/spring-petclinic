package org.springframework.samples.petclinic.owner;

import java.util.ArrayList;
import java.util.List;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class Owner_getPets_625ddd4069_Test {

    private Owner owner;
    private Pet mockPet;

    @BeforeEach
    public void setup() {
        owner = new Owner();
        mockPet = Mockito.mock(Pet.class);
    }

    @Test
    public void testGetPets_whenPetsIsNull() {
        assertNull(owner.getPets());
    }

    @Test
    public void testGetPets_whenPetsIsNotNull() {
        List<Pet> pets = new ArrayList<>();
        pets.add(mockPet);
        owner.setPets(pets);
        assertEquals(pets, owner.getPets());
    }
}
