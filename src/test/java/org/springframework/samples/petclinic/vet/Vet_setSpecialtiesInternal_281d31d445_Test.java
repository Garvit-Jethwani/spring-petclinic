package org.springframework.samples.petclinic.vet;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.samples.petclinic.model.Specialty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Vet_setSpecialtiesInternal_281d31d445_Test {
    
    private Vet vet;

    @BeforeEach
    public void setup() {
        vet = new Vet();
    }
    
    @Test
    public void testSetSpecialtiesInternal_withValidSpecialties() {
        Set<Specialty> specialties = new HashSet<>();
        Specialty specialty1 = Mockito.mock(Specialty.class);
        Specialty specialty2 = Mockito.mock(Specialty.class);
        specialties.add(specialty1);
        specialties.add(specialty2);
        
        vet.setSpecialtiesInternal(specialties);
        
        assertEquals(specialties, vet.getSpecialtiesInternal());
    }
    
    @Test
    public void testSetSpecialtiesInternal_withNullSpecialties() {
        vet.setSpecialtiesInternal(null);
        
        assertNull(vet.getSpecialtiesInternal());
    }
}
