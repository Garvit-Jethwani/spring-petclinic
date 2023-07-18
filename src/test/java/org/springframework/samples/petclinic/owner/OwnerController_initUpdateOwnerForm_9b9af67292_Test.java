package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

@RunWith(MockitoJUnitRunner.class)
public class OwnerController_initUpdateOwnerForm_9b9af67292_Test {

    @Mock
    private OwnerRepository owners;

    @Mock
    private Model model;

    @InjectMocks
    private OwnerController ownerController;

    private Owner owner;

    @Before
    public void setup() {
        owner = new Owner();
        owner.setId(1);
        owner.setFirstName("John");
        owner.setLastName("Doe");
    }

    @Test
    public void testInitUpdateOwnerForm_success() {
        when(owners.findById(1)).thenReturn(java.util.Optional.of(owner));
        String view = ownerController.initUpdateOwnerForm(1, model);
        assertEquals("owners/createOrUpdateOwnerForm", view);
    }

    @Test
    public void testInitUpdateOwnerForm_ownerNotFound() {
        when(owners.findById(1)).thenReturn(java.util.Optional.empty());
        String view = ownerController.initUpdateOwnerForm(1, model);
        assertEquals("redirect:/oups", view);
    }
}
