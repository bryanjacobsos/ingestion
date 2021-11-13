package com.os.uop.ingestion.rapi.model;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.util.JsonFormat;

import com.os.uop.ingestion.rapi.component.LogsDataTransformerIT;
import io.opentelemetry.proto.common.v1.AnyValue;
import io.opentelemetry.proto.common.v1.InstrumentationLibrary;
import io.opentelemetry.proto.common.v1.KeyValue;
import io.opentelemetry.proto.logs.v1.InstrumentationLibraryLogs;
import io.opentelemetry.proto.logs.v1.LogRecord;
import io.opentelemetry.proto.logs.v1.LogsData;
import io.opentelemetry.proto.logs.v1.ResourceLogs;
import io.opentelemetry.proto.logs.v1.SeverityNumber;
import io.opentelemetry.proto.resource.v1.Resource;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LogsTest {

    @Autowired
    RestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void protobuf() throws InvalidProtocolBufferException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<LogsData> entity = new HttpEntity<>(LogsDataTransformerIT.convertToLogsData(), headers);


        // Sends data to server
        ResponseEntity<LogsData> responseEntity = restTemplate.exchange("http://localhost:" + port + "/logs",
                HttpMethod.POST,
                entity,
                LogsData.class);

        // converts serialized LogsData into a String
        String jsonOutAgain = JsonFormat.printer().print(responseEntity.getBody().toBuilder());

        System.out.println(jsonOutAgain);
    }
}
