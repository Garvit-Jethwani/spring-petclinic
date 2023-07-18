package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.PetType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Pet_setType_7057616207_Test {

    @InjectMocks
    private Pet pet;

    private PetType petType;

    @BeforeEach
    public void setup() {
        pet = new Pet();
        petType = new PetType();
        petType.setName("Dog");
    }

    @Test
    public void testSetType() {
        pet.setType(petType);
        assertEquals(petType, pet.getType());
    }

    @Test
    public void testSetTypeNull() {
        pet.setType(null);
        assertNull(pet.getType());
    }
}
