package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class VetController_addPaginationModel_f036663c0e_Test {

    @InjectMocks
    VetController vetController;

    @Mock
    Page<Vet> paginated;

    @Mock
    Model model;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddPaginationModel_success() {
        int page = 1;
        List<Vet> listVets = Arrays.asList(new Vet(), new Vet());
        when(paginated.getContent()).thenReturn(listVets);
        when(paginated.getTotalPages()).thenReturn(5);
        when(paginated.getTotalElements()).thenReturn((long) listVets.size());

        String view = vetController.addPaginationModel(page, paginated, model);

        assertEquals("vets/vetList", view);
    }

    @Test
    public void testAddPaginationModel_noContent() {
        int page = 1;
        List<Vet> listVets = Arrays.asList();
        when(paginated.getContent()).thenReturn(listVets);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn((long) listVets.size());

        String view = vetController.addPaginationModel(page, paginated, model);

        assertEquals("vets/vetList", view);
    }
}
