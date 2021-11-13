package com.os.uop.ingestion.rapi.rest;

import com.os.uop.ingestion.rapi.service.LogsDataService;
import io.opentelemetry.proto.logs.v1.LogsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/logs")
public class LogsRest {

    @Autowired
    LogsDataService logsDataService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LogsData> postLogs(@RequestBody LogsData logsData) {

        logsDataService.writeLogs(logsData);

        return ResponseEntity.ok(logsData);
    }
}
