package com.os.uop.ingestion.rapi.rest;

import com.os.uop.ingestion.rapi.component.ExportLogsServiceRequestTransformerIT;
import io.opentelemetry.proto.collector.logs.v1.ExportLogsServiceRequest;
import io.opentelemetry.proto.logs.v1.ResourceLogs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@EmbeddedKafka(brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092"})
@DirtiesContext
@ActiveProfiles("test") // this will cause the application-test.properties and application.properties to load
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ExportLogsServiceRequestRestIT {

    @Autowired
    RestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Autowired
    ExportLogsServiceRequestConsumerIT exportLogsServiceRequestConsumerIT;

    @Test
    public void shouldGet204_and_shouldGet5ResourceLogs() throws InterruptedException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ExportLogsServiceRequest exportLogsServiceRequest = ExportLogsServiceRequestTransformerIT.convertToLogsData();

        HttpEntity<ExportLogsServiceRequest> entity = new HttpEntity<>(exportLogsServiceRequest, headers);


        // Sends data to server
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:" + port + "/logs",
                HttpMethod.POST,
                entity,
                String.class);

        assertNull(responseEntity.getBody());

        assertTrue(responseEntity.getStatusCodeValue() == 204);

        exportLogsServiceRequestConsumerIT.getLatch().await(10000, TimeUnit.MILLISECONDS);

        assertEquals(exportLogsServiceRequestConsumerIT.getLatch().getCount(), 0);

        List<ResourceLogs> resourceLogsList = exportLogsServiceRequestConsumerIT.getCollectedResourceLogs();

        System.out.println("*************************TEST OUTPUT************************************************************");
        System.out.println(resourceLogsList.size());
        assertTrue(resourceLogsList.size() == ExportLogsServiceRequestConsumerIT.NUMBER_OF_RESOURCE_LOGS);
        System.out.println("*************************TEST OUTPUT************************************************************");


    }


}
