package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.visit.Visit;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class Pet_addVisit_99c71f5c31_Test {

    @Mock
    Visit visit;

    @InjectMocks
    Pet pet;

    @BeforeEach
    void setUp() {
        pet = new Pet();
    }

    @Test
    void testAddVisitSuccess() {
        Set<Visit> visits = new HashSet<>();
        when(visit.getId()).thenReturn(1);
        visits.add(visit);
        pet.setVisits(visits);
        pet.addVisit(visit);

        assertTrue(pet.getVisits().contains(visit));
    }

    @Test
    void testAddVisitFailure() {
        Set<Visit> visits = new HashSet<>();
        when(visit.getId()).thenReturn(1);
        visits.add(visit);
        pet.setVisits(visits);
        pet.addVisit(visit);
        pet.addVisit(visit);

        assertEquals(1, pet.getVisits().size());
    }
}
