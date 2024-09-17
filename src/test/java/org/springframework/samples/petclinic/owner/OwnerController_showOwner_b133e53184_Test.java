package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.servlet.ModelAndView;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OwnerController_showOwner_b133e53184_Test {

    @Mock
    private OwnerRepository owners;

    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController();
        ownerController.setOwnerRepository(owners);
    }

    @Test
    public void testShowOwner() {
        Owner owner = new Owner();
        owner.setId(1);
        when(owners.findById(1)).thenReturn(owner);

        ModelAndView mav = ownerController.showOwner(1);
        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(owner, mav.getModel().get("owner"));
    }

    @Test
    public void testShowOwner_NotFound() {
        when(owners.findById(1)).thenReturn(null);

        ModelAndView mav = ownerController.showOwner(1);
        assertEquals("owners/ownerDetails", mav.getViewName());
        assertEquals(null, mav.getModel().get("owner"));
    }
}
