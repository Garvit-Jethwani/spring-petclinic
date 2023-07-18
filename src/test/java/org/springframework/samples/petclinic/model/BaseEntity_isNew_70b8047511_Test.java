package org.springframework.samples.petclinic.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BaseEntity_isNew_70b8047511_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testIsNewWithNullId() {
        baseEntity.setId(null);
        boolean result = baseEntity.isNew();
        assertEquals(true, result, "isNew should return true when the ID is null");
    }

    @Test
    public void testIsNewWithNonNullId() {
        baseEntity.setId(5);
        boolean result = baseEntity.isNew();
        assertEquals(false, result, "isNew should return false when the ID is not null");
    }
}
