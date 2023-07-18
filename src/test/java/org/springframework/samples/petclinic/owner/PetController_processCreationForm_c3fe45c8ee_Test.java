package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PetController_processCreationForm_c3fe45c8ee_Test {

    @Mock
    private Owner owner;

    @Mock
    private BindingResult result;

    @Mock
    private Pet pet;

    @InjectMocks
    private PetController petController;

    @Test
    public void testProcessCreationFormWithDuplicatePetName() {
        when(pet.getName()).thenReturn("Fido");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Fido", true)).thenReturn(new Pet());

        String view = petController.processCreationForm(owner, pet, result, new ModelMap());

        verify(result).rejectValue("name", "duplicate", "already exists");
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testProcessCreationFormWithFutureBirthdate() {
        when(pet.getBirthDate()).thenReturn(LocalDate.now().plusDays(1));

        String view = petController.processCreationForm(owner, pet, result, new ModelMap());

        verify(result).rejectValue("birthDate", "typeMismatch.birthDate");
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testProcessCreationFormWithValidPet() {
        when(result.hasErrors()).thenReturn(false);
        when(pet.getName()).thenReturn("Fido");
        when(pet.isNew()).thenReturn(true);
        when(owner.getPet("Fido", true)).thenReturn(null);

        String view = petController.processCreationForm(owner, pet, result, new ModelMap());

        verify(owner).addPet(pet);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessCreationFormWithError() {
        when(result.hasErrors()).thenReturn(true);

        String view = petController.processCreationForm(owner, pet, result, new ModelMap());

        assertEquals("pets/createOrUpdateForm", view);
    }
}
