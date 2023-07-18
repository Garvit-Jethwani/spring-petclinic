package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class PetController_findOwner_d0599dbdf3_Test {

    @InjectMocks
    PetController petController;

    @Mock
    OwnerRepository owners;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOwner_success() {
        Owner owner = new Owner();
        owner.setId(1);
        when(owners.findById(1)).thenReturn(owner);

        Owner result = petController.findOwner(1);
        assertEquals(owner, result);
    }

    @Test
    public void testFindOwner_ownerNotFound() {
        when(owners.findById(1)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            petController.findOwner(1);
        });

        String expectedMessage = "Owner ID not found: 1";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
