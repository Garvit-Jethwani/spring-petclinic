package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class VetController_findPaginated_d72007bfd3_Test {

    @Mock
    private VetRepository vetRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindPaginated_firstPage() {
        Vet vet1 = new Vet();
        Vet vet2 = new Vet();
        List<Vet> vets = Arrays.asList(vet1, vet2);
        Page<Vet> page = new PageImpl<>(vets);
        when(vetRepository.findAll(any(Pageable.class))).thenReturn(page);

        Page<Vet> result = findPaginated(1);

        assertEquals(2, result.getContent().size());
        assertEquals(vet1, result.getContent().get(0));
        assertEquals(vet2, result.getContent().get(1));
    }

    @Test
    public void testFindPaginated_secondPage() {
        Vet vet3 = new Vet();
        Vet vet4 = new Vet();
        List<Vet> vets = Arrays.asList(vet3, vet4);
        Page<Vet> page = new PageImpl<>(vets);
        when(vetRepository.findAll(any(Pageable.class))).thenReturn(page);

        Page<Vet> result = findPaginated(2);

        assertEquals(2, result.getContent().size());
        assertEquals(vet3, result.getContent().get(0));
        assertEquals(vet4, result.getContent().get(1));
    }

    private Page<Vet> findPaginated(int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return vetRepository.findAll(pageable);
    }
}
