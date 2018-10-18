package com.example.multidispatcherissue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MultiDispatcherIssueApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {

        // If you uncomment the lines then the test will finish faster
        // ResponseEntity<String> service1Response = restTemplate.getForEntity("/service1", String.class);
        // assertThat(service1Response.getStatusCode()).as(service1Response.toString()).isEqualTo(HttpStatus.OK);

        ResponseEntity<JsonNode> response = restTemplate.getForEntity("/actuator/mappings", JsonNode.class);
        assertThat(response.getStatusCode()).as(response.toString()).isEqualTo(HttpStatus.OK);
    }
}
