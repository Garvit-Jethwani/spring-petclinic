package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PetValidator_validate_70e0541fd5_Test {

    @Mock
    private Pet pet;

    private Validator petValidator;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        petValidator = new PetValidator();
    }

    @Test
    public void testValidateWithNoName() {
        when(pet.getName()).thenReturn("");
        Errors errors = new BeanPropertyBindingResult(pet, "pet");
        petValidator.validate(pet, errors);
        assertEquals(errors.getFieldError("name").getCode(), "REQUIRED");
    }

    @Test
    public void testValidateWithNoType() {
        when(pet.getType()).thenReturn(null);
        Errors errors = new BeanPropertyBindingResult(pet, "pet");
        petValidator.validate(pet, errors);
        assertEquals(errors.getFieldError("type").getCode(), "REQUIRED");
    }

    @Test
    public void testValidateWithNoBirthDate() {
        when(pet.getBirthDate()).thenReturn(null);
        Errors errors = new BeanPropertyBindingResult(pet, "pet");
        petValidator.validate(pet, errors);
        assertEquals(errors.getFieldError("birthDate").getCode(), "REQUIRED");
    }

    @Test
    public void testValidateWithValidPet() {
        when(pet.getName()).thenReturn("Fido");
        when(pet.getType()).thenReturn(new PetType());
        when(pet.getBirthDate()).thenReturn(LocalDate.now());
        Errors errors = new BeanPropertyBindingResult(pet, "pet");
        petValidator.validate(pet, errors);
        assertEquals(errors.hasErrors(), false);
    }
}
