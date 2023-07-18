package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import java.time.LocalDate;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

public class PetController_processUpdateForm_e1332752ad_Test {

    @InjectMocks
    PetController petController;

    @Mock
    Owner owner;

    @Mock
    Pet pet;

    @Mock
    ModelMap model;

    @Mock
    BindingResult result;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProcessUpdateForm_PetNameExists() {
        when(pet.getName()).thenReturn("Fido");
        when(owner.getPet(anyString(), anyBoolean())).thenReturn(new Pet());
        when(pet.getId()).thenReturn(1);
        when(owner.getPet(anyString(), anyBoolean()).getId()).thenReturn(2);
        String view = petController.processUpdateForm(pet, result, owner, model);
        verify(result).rejectValue("name", "duplicate", "already exists");
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testProcessUpdateForm_PetBirthDateInFuture() {
        when(pet.getBirthDate()).thenReturn(LocalDate.now().plusDays(1));
        String view = petController.processUpdateForm(pet, result, owner, model);
        verify(result).rejectValue("birthDate", "typeMismatch.birthDate");
        assertEquals("pets/createOrUpdateForm", view);
    }

    @Test
    public void testProcessUpdateForm_Success() {
        when(pet.getName()).thenReturn("Fido");
        when(owner.getPet(anyString(), anyBoolean())).thenReturn(null);
        String view = petController.processUpdateForm(pet, result, owner, model);
        verify(owner).addPet(pet);
        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
