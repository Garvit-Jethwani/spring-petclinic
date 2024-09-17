package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NamedEntity_setName_f5bd015150_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testSetName_ValidName() {
        String expectedName = "Test Name";
        namedEntity.setName(expectedName);
        assertEquals(expectedName, namedEntity.getName());
    }

    @Test
    public void testSetName_NullName() {
        namedEntity.setName(null);
        assertNull(namedEntity.getName());
    }
}
