package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

@RunWith(MockitoJUnitRunner.class)
public class OwnerController_processUpdateOwnerForm_f37e6381ef_Test {

    @InjectMocks
    OwnerController ownerController;

    @Mock
    OwnerRepository owners;

    @Mock
    BindingResult result;

    @Mock
    Owner owner;

    @Before
    public void setup() {
        when(owner.getId()).thenReturn(1);
    }

    @Test
    public void testProcessUpdateOwnerForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        verify(owner).setId(1);
        verify(owners).save(owner);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessUpdateOwnerForm_Failure() {
        when(result.hasErrors()).thenReturn(true);
        String view = ownerController.processUpdateOwnerForm(owner, result, 1);
        verify(owner, never()).setId(anyInt());
        verify(owners, never()).save(any(Owner.class));
        assertEquals("VIEWS_OWNER_CREATE_OR_UPDATE_FORM", view);
    }
}
