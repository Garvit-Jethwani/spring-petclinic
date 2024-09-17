// Test generated by RoostGPT for test petclinic-springboot using AI Type Open AI and AI Model gpt-4

package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OwnerController_OwnerController_35fab86ffa_Test {

    private OwnerRepository mockOwnerRepository;
    private OwnerController ownerController;

    @BeforeEach
    public void setUp() {
        mockOwnerRepository = mock(OwnerRepository.class);
        ownerController = new OwnerController(mockOwnerRepository);
    }

    @Test
    public void testOwnerControllerConstructor_Success() {
        assertEquals(mockOwnerRepository, ownerController.getOwners());
    }

    @Test
    public void testOwnerControllerConstructor_Failure() {
        OwnerRepository anotherMockOwnerRepository = mock(OwnerRepository.class);
        when(anotherMockOwnerRepository.findAll()).thenReturn(null);
        ownerController = new OwnerController(anotherMockOwnerRepository);
        assertEquals(anotherMockOwnerRepository, ownerController.getOwners());
    }
}