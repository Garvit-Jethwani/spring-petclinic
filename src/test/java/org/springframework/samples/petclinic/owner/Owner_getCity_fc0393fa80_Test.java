package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

public class Owner_getCity_fc0393fa80_Test {
    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
    }

    @Test
    public void testGetCity_Succeeds_WhenCityIsSet() {
        String expectedCity = "New York";
        person.setCity(expectedCity);
        String actualCity = person.getCity();
        Assertions.assertEquals(expectedCity, actualCity, "City should be equal to the set value");
    }

    @Test
    public void testGetCity_ReturnsNull_WhenCityIsNotSet() {
        String actualCity = person.getCity();
        Assertions.assertNull(actualCity, "City should be null when it is not set");
    }
}
