package com.example.assigment2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = {com.example.assigment2.CachingApplicationTest.class})
class CachingApplicationTest {

    @Test
    void contextLoads() {
        // This test method can be empty; it's just used to ensure that the application context loads successfully
    }
}