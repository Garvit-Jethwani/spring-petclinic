package org.springframework.samples.petclinic.vet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.samples.petclinic.model.Specialty;
import java.util.HashSet;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Vet_getNrOfSpecialties_f8247daaad_Test {

    @InjectMocks
    Vet vet;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetNrOfSpecialtiesWhenSpecialtiesExist() {
        Set<Specialty> specialties = new HashSet<>();
        Specialty specialty1 = new Specialty();
        specialty1.setName("Cardiology");
        Specialty specialty2 = new Specialty();
        specialty2.setName("Dentistry");
        specialties.add(specialty1);
        specialties.add(specialty2);
        vet.setSpecialtiesInternal(specialties);
        assertEquals(2, vet.getNrOfSpecialties());
    }

    @Test
    public void testGetNrOfSpecialtiesWhenNoSpecialtiesExist() {
        Set<Specialty> specialties = new HashSet<>();
        vet.setSpecialtiesInternal(specialties);
        assertEquals(0, vet.getNrOfSpecialties());
    }

}
