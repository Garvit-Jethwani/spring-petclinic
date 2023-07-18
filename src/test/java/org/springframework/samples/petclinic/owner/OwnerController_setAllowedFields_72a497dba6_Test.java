package org.springframework.samples.petclinic.owner;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.verify;

public class OwnerController_setAllowedFields_72a497dba6_Test {

    @Mock
    private WebDataBinder dataBinder;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSetAllowedFields() {
        OwnerController controller = new OwnerController();
        controller.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields(new String[]{"id"});
    }

    @Test
    public void testSetAllowedFieldsWithDifferentField() {
        OwnerController controller = new OwnerController();
        controller.setAllowedFields(dataBinder);
        verify(dataBinder).setDisallowedFields(new String[]{"otherField"});
    }
}
