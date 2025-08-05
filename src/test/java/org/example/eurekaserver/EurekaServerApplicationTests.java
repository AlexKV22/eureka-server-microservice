package org.example.eurekaserver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EurekaServerApplicationTests {

    private final TestRestTemplate restTemplate;

    @Autowired
    public EurekaServerApplicationTests(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Test
    void contextLoadsTest() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8888/eureka-server/default", String.class);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
        System.out.println(response.getBody());
        Assertions.assertTrue(response.getBody().contains("eureka-server"));
    }
}
