package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

public class PetController_initPetBinder_b0b1928cff_Test {

    @InjectMocks
    PetController petController = new PetController();

    @Mock
    WebDataBinder dataBinder = new WebDataBinder();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitPetBinder() {
        petController.initPetBinder(dataBinder);
        verify(dataBinder).setValidator(any(PetValidator.class));
    }

    @Test
    public void testPetValidator() {
        PetValidator petValidator = new PetValidator();
        Pet pet = new Pet();
        Errors errors = new BeanPropertyBindingResult(pet, "pet");
        petValidator.validate(pet, errors);
        assertEquals(errors.getFieldErrorCount(), 0);
    }
}
