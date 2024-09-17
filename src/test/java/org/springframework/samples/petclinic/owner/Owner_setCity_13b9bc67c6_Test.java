package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.util.Assert;

public class Owner_setCity_13b9bc67c6_Test {

    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person();
    }

    @Test
    public void testSetCity_ValidCity() {
        String city = "New York";
        person.setCity(city);
        Assert.isTrue(person.getCity().equals(city), "City should be set to: " + city);
    }

    @Test
    public void testSetCity_NullCity() {
        String city = null;
        person.setCity(city);
        Assert.isTrue(person.getCity() == null, "City should be set to null");
    }

    @Test
    public void testSetCity_EmptyCity() {
        String city = "";
        person.setCity(city);
        Assert.isTrue(person.getCity().equals(city), "City should be set to an empty string");
    }
}
