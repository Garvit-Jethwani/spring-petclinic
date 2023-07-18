package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.samples.petclinic.model.Person;
import org.springframework.core.style.ToStringCreator;
import org.springframework.util.Assert;

@SpringBootTest
public class Owner_toString_2393b88875_Test {

    private Person person;

    @BeforeEach
    public void setup() {
        person = new Person();
        person.setId(1);
        person.setNew(true);
        person.setLastName("Doe");
        person.setFirstName("John");
        person.setAddress("123 Main St");
        person.setCity("New York");
        person.setTelephone("1234567890");
    }

    @Test
    public void testToString() {
        String expected = new ToStringCreator(person).append("id", person.getId())
                .append("new", person.isNew())
                .append("lastName", person.getLastName())
                .append("firstName", person.getFirstName())
                .append("address", person.getAddress())
                .append("city", person.getCity())
                .append("telephone", person.getTelephone())
                .toString();
        
        Assert.isTrue(expected.equals(person.toString()), "toString method does not return expected string");
    }

    @Test
    public void testToStringWithEmptyValues() {
        person = new Person();
        String expected = new ToStringCreator(person).append("id", person.getId())
                .append("new", person.isNew())
                .append("lastName", person.getLastName())
                .append("firstName", person.getFirstName())
                .append("address", person.getAddress())
                .append("city", person.getCity())
                .append("telephone", person.getTelephone())
                .toString();
        
        Assert.isTrue(expected.equals(person.toString()), "toString method does not return expected string for empty values");
    }
}
