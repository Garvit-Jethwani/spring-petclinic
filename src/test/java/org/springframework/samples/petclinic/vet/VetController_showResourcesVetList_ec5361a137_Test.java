package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.samples.petclinic.vet.VetRepository;
import org.springframework.samples.petclinic.vet.Vets;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VetController_showResourcesVetList_ec5361a137_Test {

    @InjectMocks
    VetController vetController;

    @Mock
    VetRepository vetRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowResourcesVetList() {
        Vet vet1 = new Vet();
        vet1.setId(1);
        vet1.setFirstName("John");
        vet1.setLastName("Doe");

        Vet vet2 = new Vet();
        vet2.setId(2);
        vet2.setFirstName("Jane");
        vet2.setLastName("Doe");

        when(vetRepository.findAll()).thenReturn(Arrays.asList(vet1, vet2));

        Vets vets = vetController.showResourcesVetList();

        assertEquals(2, vets.getVetList().size());
        assertEquals("John", vets.getVetList().get(0).getFirstName());
        assertEquals("Jane", vets.getVetList().get(1).getFirstName());
    }

    @Test
    public void testShowResourcesVetList_noVets() {
        when(vetRepository.findAll()).thenReturn(Arrays.asList());

        Vets vets = vetController.showResourcesVetList();

        assertEquals(0, vets.getVetList().size());
    }
}
