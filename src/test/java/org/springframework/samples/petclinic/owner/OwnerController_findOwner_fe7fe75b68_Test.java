package org.springframework.samples.petclinic.owner;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController_findOwner_fe7fe75b68_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository ownerRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindOwner_NullId() {
        Owner owner = ownerController.findOwner(null);
        assertEquals("New owner should be created when Id is null", new Owner(), owner);
    }

    @Test
    public void testFindOwner_ValidId() {
        Integer ownerId = 1;
        Owner expectedOwner = new Owner();
        when(ownerRepository.findById(ownerId)).thenReturn(java.util.Optional.ofNullable(expectedOwner));

        Owner actualOwner = ownerController.findOwner(ownerId);

        assertEquals("Owner should be found when Id is valid", expectedOwner, actualOwner);
    }
}
