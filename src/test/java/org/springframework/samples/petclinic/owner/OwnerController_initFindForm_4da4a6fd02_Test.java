package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController_initFindForm_4da4a6fd02_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private Model model;

    @Mock
    private BindingResult result;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitFindFormSuccess() {
        String viewName = ownerController.initFindForm(model);
        assertEquals("owners/findOwners", viewName);
    }

    @Test
    public void testInitFindFormFailure() {
        when(result.hasErrors()).thenReturn(true);
        String viewName = ownerController.initFindForm(model);
        assertEquals("owners/findOwners", viewName);
        verify(result).hasErrors();
    }
}
