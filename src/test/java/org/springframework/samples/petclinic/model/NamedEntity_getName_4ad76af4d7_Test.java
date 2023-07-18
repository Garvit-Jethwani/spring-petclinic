package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NamedEntity_getName_4ad76af4d7_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setUp() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testGetName_WhenNameIsSet_ShouldReturnCorrectName() {
        String expectedName = "Test Name";
        namedEntity.setName(expectedName);
        String actualName = namedEntity.getName();
        assertEquals(expectedName, actualName, "Expected name does not match actual name");
    }

    @Test
    public void testGetName_WhenNameIsNotSet_ShouldReturnNull() {
        String actualName = namedEntity.getName();
        assertEquals(null, actualName, "Expected name to be null when not set");
    }
}
