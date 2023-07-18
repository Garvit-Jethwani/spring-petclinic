package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

public class VisitControllerProcessNewVisitForm848cdf95b6Test {

    @InjectMocks
    private VisitController visitController;

    @Mock
    private Owner owner;

    @Mock
    private BindingResult result;

    @Mock
    private Visit visit;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testProcessNewVisitFormWithErrors() {
        when(result.hasErrors()).thenReturn(true);

        String view = visitController.processNewVisitForm(owner, 1, visit, result);

        assertEquals("pets/createOrUpdateVisitForm", view);
    }

    @Test
    public void testProcessNewVisitFormWithoutErrors() {
        when(result.hasErrors()).thenReturn(false);

        String view = visitController.processNewVisitForm(owner, 1, visit, result);

        verify(owner).addVisit(1, visit);
        verify(owner).save(owner);
        assertEquals("redirect:/owners/{ownerId}", view);
    }
}
