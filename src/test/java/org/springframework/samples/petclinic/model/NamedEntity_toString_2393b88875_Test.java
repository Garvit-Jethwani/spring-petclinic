package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NamedEntity_toString_2393b88875_Test {

    private NamedEntity namedEntity;

    @BeforeEach
    public void setup() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testToString_WhenNameIsNotNull() {
        String expectedName = "Test Name";
        namedEntity.setName(expectedName);

        String actualName = namedEntity.toString();

        Assertions.assertEquals("NamedEntity [name=" + expectedName + "]", actualName, "The expected name does not match the actual name");
    }

    @Test
    public void testToString_WhenNameIsNull() {
        namedEntity.setName(null);

        String actualName = namedEntity.toString();

        Assertions.assertEquals("NamedEntity [name=null]", actualName, "The name should be null");
    }
}
