package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

public class PetController_initCreationForm_b0b57b1f82_Test {
    private PetController petController;
    private Owner owner;
    private ModelMap model;

    @BeforeEach
    public void setup() {
        petController = new PetController();
        owner = mock(Owner.class);
        model = new ModelMap();
    }

    @Test
    public void testInitCreationForm_Success() {
        String view = petController.initCreationForm(owner, model);
        verify(owner).addPet((Pet) model.get("pet"));
        assertEquals("pets/createOrUpdatePetForm", view);
    }

    @Test
    public void testInitCreationForm_NullOwner() {
        try {
            petController.initCreationForm(null, model);
        } catch (IllegalArgumentException e) {
            assertEquals("Owner must not be null", e.getMessage());
        }
    }

    @Test
    public void testInitCreationForm_NullModel() {
        try {
            petController.initCreationForm(owner, null);
        } catch (IllegalArgumentException e) {
            assertEquals("ModelMap must not be null", e.getMessage());
        }
    }
}
