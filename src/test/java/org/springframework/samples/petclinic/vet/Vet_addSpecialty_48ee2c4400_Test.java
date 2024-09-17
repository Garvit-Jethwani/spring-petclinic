package org.springframework.samples.petclinic.vet;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Vet_addSpecialty_48ee2c4400_Test {

    private Vet vet;
    private Specialty specialty1;
    private Specialty specialty2;

    @BeforeEach
    public void setup() {
        vet = new Vet();
        specialty1 = new Specialty();
        specialty1.setName("specialty1");
        specialty2 = new Specialty();
        specialty2.setName("specialty2");
    }

    @Test
    public void testAddSpecialty() {
        vet.addSpecialty(specialty1);
        assertTrue(vet.getSpecialties().contains(specialty1));
    }

    @Test
    public void testAddSpecialty_NotPresent() {
        vet.addSpecialty(specialty1);
        assertFalse(vet.getSpecialties().contains(specialty2));
    }

}
