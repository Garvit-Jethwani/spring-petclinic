package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.verify;

public class VisitController_setAllowedFields_72a497dba6_Test {
    @Mock
    private WebDataBinder dataBinder;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetAllowedFields_DisallowsIdField() {
        VisitController visitController = new VisitController();
        visitController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testSetAllowedFields_DisallowsNonexistentField() {
        VisitController visitController = new VisitController();
        visitController.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields("nonexistent");
    }
}
