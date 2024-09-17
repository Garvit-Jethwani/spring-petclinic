package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController_processCreationForm_9aa1f495ef_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private BindingResult result;

    @Mock
    private Owner owner;

    @Test
    public void testProcessCreationForm_Success() {
        when(result.hasErrors()).thenReturn(false);
        when(owner.getId()).thenReturn(1);

        String view = ownerController.processCreationForm(owner, result);

        assertEquals("redirect:/owners/1", view);
    }

    @Test
    public void testProcessCreationForm_Failure() {
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processCreationForm(owner, result);

        assertEquals("ownerCreateOrUpdateForm", view);
    }
}
