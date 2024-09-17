package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.BaseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BaseEntity_getId_09ace845cd_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setup() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testGetIdSuccess() {
        baseEntity.setId(1);
        Integer expected = 1;
        Integer actual = baseEntity.getId();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetIdNull() {
        Integer actual = baseEntity.getId();
        assertEquals(null, actual);
    }
}
