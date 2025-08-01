package org.example.eurekaserver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Disabled
class EurekaServerApplicationTests {

    private final TestRestTemplate restTemplate;

    @Autowired
    public EurekaServerApplicationTests(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8888/config-server/default", String.class);
        Assertions.assertEquals(200, response.getStatusCodeValue());
    }
}
