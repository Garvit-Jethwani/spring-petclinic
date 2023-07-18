package org.springframework.samples.petclinic.owner;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Pet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Owner_getPet_a2da54c166_Test {

    private Owner owner;
    private Pet pet1, pet2;

    @BeforeEach
    public void setUp() {
        owner = new Owner();
        pet1 = new Pet();
        pet1.setName("Fido");
        pet1.setNew(true);
        pet2 = new Pet();
        pet2.setName("Buddy");
        owner.setPetsInternal(new HashSet<>(Arrays.asList(pet1, pet2)));
    }

    @Test
    public void testGetPet_ignoreNew() {
        Pet actual = owner.getPet("Fido", true);
        assertNull(actual, "Should return null as pet is new and ignoreNew is true");
    }

    @Test
    public void testGetPet_notIgnoreNew() {
        Pet actual = owner.getPet("Fido", false);
        assertEquals(pet1, actual, "Should return the pet as ignoreNew is false");
    }

    @Test
    public void testGetPet_nonExistentPet() {
        Pet actual = owner.getPet("NonExistent", false);
        assertNull(actual, "Should return null as pet does not exist");
    }

    @Test
    public void testGetPet_caseInsensitive() {
        Pet actual = owner.getPet("fIdO", false);
        assertEquals(pet1, actual, "Should return the pet as name comparison is case insensitive");
    }
}
