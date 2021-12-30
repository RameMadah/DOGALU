package com.example.htw.berlin.webtech.demo;

import com.example.htw.berlin.webtech.demo.persistence.BlogEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName( "should Check if the App can do the greetings")
    void greeting() {
        Application g = new Application();
        assertEquals("Hello World!", g.greetings());
    }


}
