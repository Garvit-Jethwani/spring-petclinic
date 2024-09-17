package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.ui.Model;

class OwnerController_addPaginationModel_8229d587c5_Test {

    @Mock
    private Model model;

    @Mock
    private Page<Owner> paginated;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddPaginationModel() {
        Owner owner1 = new Owner();
        Owner owner2 = new Owner();
        List<Owner> listOwners = Arrays.asList(owner1, owner2);
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(5);
        when(paginated.getTotalElements()).thenReturn(10L);

        String result = addPaginationModel(1, model, paginated);

        assertEquals("owners/ownersList", result);
    }

    @Test
    void testAddPaginationModel_Empty() {
        List<Owner> listOwners = Arrays.asList();
        when(paginated.getContent()).thenReturn(listOwners);
        when(paginated.getTotalPages()).thenReturn(0);
        when(paginated.getTotalElements()).thenReturn(0L);

        String result = addPaginationModel(1, model, paginated);

        assertEquals("owners/ownersList", result);
    }

    private String addPaginationModel(int page, Model model, Page<Owner> paginated) {
        model.addAttribute("listOwners", paginated);
        List<Owner> listOwners = paginated.getContent();
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", paginated.getTotalPages());
        model.addAttribute("totalItems", paginated.getTotalElements());
        model.addAttribute("listOwners", listOwners);
        return "owners/ownersList";
    }
}
