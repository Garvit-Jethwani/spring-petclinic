package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PetTypeFormatter_PetTypeFormatter_aab2a90f9f_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetTypeFormatter petTypeFormatter;

    @BeforeEach
    public void setUp() {
        petTypeFormatter = new PetTypeFormatter();
    }

    @Test
    public void testPetTypeFormatter_ValidOwnerRepository() {
        assertNotNull(petTypeFormatter);
    }

    @Test
    public void testPetTypeFormatter_NullOwnerRepository() {
        assertThrows(NullPointerException.class, () -> {
            new PetTypeFormatter();
        });
    }
}
