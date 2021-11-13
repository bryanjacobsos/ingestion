package com.os.uop.ingestion.rapi.rest;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.os.uop.ingestion.rapi.component.LogsDataTransformerIT;
import io.opentelemetry.proto.collector.logs.v1.ExportLogsServiceRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogsRestIT {

    @Autowired
    RestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void protobuf() throws InvalidProtocolBufferException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ExportLogsServiceRequest exportLogsServiceRequest = LogsDataTransformerIT.convertToLogsData();

        HttpEntity<ExportLogsServiceRequest> entity = new HttpEntity<>(exportLogsServiceRequest, headers);


        // Sends data to server
        ResponseEntity<ExportLogsServiceRequest> responseEntity = restTemplate.exchange("http://localhost:" + port + "/logs",
                HttpMethod.POST,
                entity,
                ExportLogsServiceRequest.class);

        // converts serialized LogsData into a String
        String jsonOutAgain = JsonFormat.printer().print(responseEntity.getBody().toBuilder());

        String expected = JsonFormat.printer().print(exportLogsServiceRequest.toBuilder());

        assertEquals(expected, jsonOutAgain);
    }
}
