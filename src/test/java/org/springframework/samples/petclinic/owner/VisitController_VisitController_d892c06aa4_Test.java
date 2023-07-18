package org.springframework.samples.petclinic.owner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class VisitController_VisitController_d892c06aa4_Test {

    @Mock
    private OwnerRepository owners;

    private VisitController visitController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        visitController = new VisitController();
    }

    @Test
    public void testConstructor_withValidOwnerRepository() {
        assertThat(visitController).isNotNull();
    }

    @Test
    public void testConstructor_withNullOwnerRepository() {
        Exception exception = null;
        try {
            new VisitController();
        } catch (Exception e) {
            exception = e;
        }
        assertThat(exception).isInstanceOf(NullPointerException.class);
    }
}
