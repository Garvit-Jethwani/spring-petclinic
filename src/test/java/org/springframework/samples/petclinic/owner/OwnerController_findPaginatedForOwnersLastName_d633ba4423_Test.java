package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController_findPaginatedForOwnersLastName_d633ba4423_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_success() {
        Owner owner1 = new Owner();
        owner1.setLastName("Smith");
        Owner owner2 = new Owner();
        owner2.setLastName("Smith");
        List<Owner> ownerList = Arrays.asList(owner1, owner2);
        Page<Owner> ownerPage = new PageImpl<>(ownerList);

        when(owners.findByLastName("Smith", PageRequest.of(0, 5))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Smith");
        assertEquals(ownerPage, result);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_noOwnersFound() {
        Page<Owner> ownerPage = Page.empty();

        when(owners.findByLastName("Doe", PageRequest.of(0, 5))).thenReturn(ownerPage);

        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(1, "Doe");
        assertEquals(ownerPage, result);
    }
}
