package org.springframework.samples.petclinic.system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class WelcomeController_welcome_5d8ab38f2f_Test {

    @Autowired
    private WelcomeController controller;

    @MockBean
    private SomeExternalService externalService; // Replace with actual service

    @Test
    public void testWelcome() {
        String expected = "welcome";
        String actual = controller.welcome();
        assertEquals(expected, actual);
    }

    @Test
    public void testWelcomeWithMockedService() {
        // Assuming that the welcome method uses some external service
        // Replace with actual service and expected response
        when(externalService.call()).thenReturn("mocked response");

        String expected = "welcome";
        String actual = controller.welcome();
        assertEquals(expected, actual);
    }
}
