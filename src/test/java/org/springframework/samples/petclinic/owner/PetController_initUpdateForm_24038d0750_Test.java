package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetController_initUpdateForm_24038d0750_Test {

    @InjectMocks
    private PetController petController = new PetController();

    @Mock
    private Owner owner = new Owner();

    @Mock
    private Pet pet = new Pet();

    @Test
    public void testInitUpdateForm_ValidPetId() {
        int petId = 1;
        ModelMap model = new ModelMap();

        when(owner.getPet(petId)).thenReturn(pet);

        String view = petController.initUpdateForm(owner, petId, model);

        assertEquals(pet, model.get("pet"));
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testInitUpdateForm_InvalidPetId() {
        int petId = 2;
        ModelMap model = new ModelMap();

        when(owner.getPet(petId)).thenReturn(null);

        String view = petController.initUpdateForm(owner, petId, model);

        assertEquals(null, model.get("pet"));
        assertEquals("pets/createOrUpdateForm", view);
    }
}
