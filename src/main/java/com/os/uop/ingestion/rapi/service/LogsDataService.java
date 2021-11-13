package com.os.uop.ingestion.rapi.service;

import com.os.uop.ingestion.rapi.component.LogsDataTransformer;
import com.os.uop.ingestion.rapi.model.ResourceLogsWrapper;
import com.os.uop.ingestion.rapi.repo.ResourceLogsRepo;
import io.opentelemetry.proto.collector.logs.v1.ExportLogsServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsDataService {

    @Autowired
    LogsDataTransformer logsDataTransformer;

    @Autowired
    ResourceLogsRepo resourceLogsRepo;

    public void writeLogs(ExportLogsServiceRequest logsData) {

        List<ResourceLogsWrapper> resourceLogsWrappers =
                logsDataTransformer.transformLogsDataToResourceLogsWrapper(logsData);

        resourceLogsWrappers.forEach(resourceLogsWrapper ->
                resourceLogsRepo.send(resourceLogsWrapper.getResourceLogs()));

    }

}
