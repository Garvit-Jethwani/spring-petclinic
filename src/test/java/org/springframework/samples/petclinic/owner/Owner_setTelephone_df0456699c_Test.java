package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.Owner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class Owner_setTelephone_df0456699c_Test {

    private Owner owner;

    @BeforeEach
    public void setup() {
        owner = new Owner();
    }

    @Test
    public void testSetTelephone_ValidNumber() {
        String validTelephone = "1234567890";
        owner.setTelephone(validTelephone);
        assertEquals(validTelephone, owner.getTelephone());
    }

    @Test
    public void testSetTelephone_EmptyString() {
        String emptyTelephone = "";
        owner.setTelephone(emptyTelephone);
        assertEquals(emptyTelephone, owner.getTelephone());
    }
}
