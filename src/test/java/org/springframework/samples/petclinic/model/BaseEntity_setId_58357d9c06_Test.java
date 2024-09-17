package org.springframework.samples.petclinic.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class BaseEntity_setId_58357d9c06_Test {

    private BaseEntity baseEntity;

    @BeforeEach
    public void setUp() {
        baseEntity = new BaseEntity();
    }

    @Test
    public void testSetId() {
        Integer expectedId = 1;
        baseEntity.setId(expectedId);
        assertEquals(expectedId, baseEntity.getId(), "The ID set does not match the expected ID");
    }

    @Test
    public void testSetIdWithNull() {
        baseEntity.setId(null);
        assertNull(baseEntity.getId(), "The ID is not null after being set to null");
    }
}
