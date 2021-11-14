package com.os.uop.ingestion.rapi.rest;

import com.os.uop.ingestion.rapi.service.ExportLogsServiceRequestService;
import io.opentelemetry.proto.collector.logs.v1.ExportLogsServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // This creates a piece of code that is exposed over http
@RequestMapping(path = "/logs") // this means http://host:port/logs
public class ExportLogsServiceRequestRest {

    @Autowired // spring injects this service
    ExportLogsServiceRequestService exportLogsServiceRequestService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE) // means the http method is POST and accepts JSON
    public ResponseEntity postLogs(@RequestBody ExportLogsServiceRequest exportLogsServiceRequest) {

        exportLogsServiceRequestService.writeLogs(exportLogsServiceRequest);

        return ResponseEntity.noContent().build();
    }
}
