package org.springframework.samples.petclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.vet.Vet;

import static org.mockito.Mockito.verify;

public class PetClinicRuntimeHintsRegisterHintsTest {

    @Mock
    private RuntimeHints hints;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterHints() {
        PetClinicRuntimeHintsRegisterHintsTest petClinicRuntimeHints = new PetClinicRuntimeHintsRegisterHintsTest();
        petClinicRuntimeHints.registerHints(hints, this.getClass().getClassLoader());

        verify(hints.resources()).registerPattern("db/*");
        verify(hints.resources()).registerPattern("messages/*");
        verify(hints.resources()).registerPattern("META-INF/resources/webjars/*");
        verify(hints.resources()).registerPattern("mysql-default-conf");
        verify(hints.serialization()).registerType(BaseEntity.class);
        verify(hints.serialization()).registerType(Person.class);
        verify(hints.serialization()).registerType(Vet.class);
    }

    @Test
    public void testRegisterHintsWithNullClassLoader() {
        PetClinicRuntimeHintsRegisterHintsTest petClinicRuntimeHints = new PetClinicRuntimeHintsRegisterHintsTest();
        petClinicRuntimeHints.registerHints(hints, null);

        verify(hints.resources()).registerPattern("db/*");
        verify(hints.resources()).registerPattern("messages/*");
        verify(hints.resources()).registerPattern("META-INF/resources/webjars/*");
        verify(hints.resources()).registerPattern("mysql-default-conf");
        verify(hints.serialization()).registerType(BaseEntity.class);
        verify(hints.serialization()).registerType(Person.class);
        verify(hints.serialization()).registerType(Vet.class);
    }
}
