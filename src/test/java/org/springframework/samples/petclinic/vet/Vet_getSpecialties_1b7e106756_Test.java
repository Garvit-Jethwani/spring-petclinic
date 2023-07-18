package org.springframework.samples.petclinic.vet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Vet_getSpecialties_1b7e106756_Test {

    @Mock
    private Vet vet;

    @InjectMocks
    private VetService vetService;

    private List<Specialty> specialties;

    @BeforeEach
    public void setup() {
        specialties = new ArrayList<>();
        Specialty specialty1 = new Specialty();
        specialty1.setName("Cardiology");
        specialties.add(specialty1);

        Specialty specialty2 = new Specialty();
        specialty2.setName("Dentistry");
        specialties.add(specialty2);

        when(vet.getSpecialtiesInternal()).thenReturn(new HashSet<>(specialties));
    }

    @Test
    public void testGetSpecialties() {
        List<Specialty> sortedSpecs = new ArrayList<>(specialties);
        PropertyComparator.sort(sortedSpecs, new MutableSortDefinition("name", true, true));
        when(vet.getSpecialties()).thenReturn(Collections.unmodifiableList(sortedSpecs));

        List<Specialty> result = vetService.getSpecialties();

        assertEquals(sortedSpecs, result);
    }

    @Test
    public void testGetSpecialties_Empty() {
        when(vet.getSpecialtiesInternal()).thenReturn(new HashSet<>());

        List<Specialty> result = vetService.getSpecialties();

        assertEquals(Collections.emptyList(), result);
    }
}
