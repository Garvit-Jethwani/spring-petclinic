package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetTypeFormatter_print_bd9d8d12f6_Test {

    @Mock
    private PetType petType;

    @InjectMocks
    private PetTypeFormatter petTypeFormatter;

    @BeforeEach
    public void setUp() {
        LocaleContextHolder.setLocale(Locale.ENGLISH);
        petType = new PetType();
        petTypeFormatter = new PetTypeFormatter();
    }

    @Test
    public void testPrint_PetTypeExists() {
        String petTypeName = "Dog";
        when(petType.getName()).thenReturn(petTypeName);

        String result = petTypeFormatter.print(petType, LocaleContextHolder.getLocale());

        assertEquals(petTypeName, result);
    }

    @Test
    public void testPrint_PetTypeIsNull() {
        String result = petTypeFormatter.print(null, LocaleContextHolder.getLocale());

        assertEquals("", result);
    }

}
