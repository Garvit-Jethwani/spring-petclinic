package org.springframework.samples.petclinic.vet;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.vet.Vet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Vets_getVetList_5675351922_Test {

    @InjectMocks
    private VetService vetService;

    @Mock
    private VetRepository vetRepository;

    @BeforeEach
    public void setup() {
        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Doe");

        Vet vet2 = new Vet();
        vet2.setFirstName("Jane");
        vet2.setLastName("Doe");

        List<Vet> vets = new ArrayList<>();
        vets.add(vet1);
        vets.add(vet2);

        when(vetRepository.findAll()).thenReturn(vets);
    }

    @Test
    public void testGetVetList() {
        List<Vet> result = vetService.getVetList();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testGetVetList_empty() {
        when(vetRepository.findAll()).thenReturn(new ArrayList<>());

        List<Vet> result = vetService.getVetList();
        assertNotNull(result);
        assertEquals(0, result.size());
    }
}
