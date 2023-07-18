package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class VetController_VetController_2752163909_Test {

    @Mock
    private VetRepository vetRepository;

    @InjectMocks
    private VetController vetController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVetController() {
        Vet vet = new Vet();
        vet.setFirstName("John");
        vet.setLastName("Doe");

        List<Vet> vets = new ArrayList<>();
        vets.add(vet);

        when(vetRepository.findAll()).thenReturn(vets);

        List<Vet> result = vetController.showVetList();
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getFirstName());
        assertEquals("Doe", result.get(0).getLastName());
    }

    @Test
    public void testVetController_noVets() {
        List<Vet> vets = new ArrayList<>();

        when(vetRepository.findAll()).thenReturn(vets);

        List<Vet> result = vetController.showVetList();
        assertEquals(0, result.size());
    }
}
