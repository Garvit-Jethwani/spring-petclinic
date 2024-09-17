package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class PetController_initOwnerBinder_ae5e2b131f_Test {

    @Test
    public void testInitOwnerBinder() {
        WebDataBinder dataBinder = mock(WebDataBinder.class);

        PetController controller = new PetController();
        controller.initOwnerBinder(dataBinder);

        verify(dataBinder).setDisallowedFields("id");
    }

    @Test
    public void testInitOwnerBinderWithNull() {
        WebDataBinder dataBinder = null;

        PetController controller = new PetController();
        assertThrows(NullPointerException.class, () -> controller.initOwnerBinder(dataBinder));
    }
}
