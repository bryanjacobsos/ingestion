package com.os.uop.ingestion.rapi.service;

import com.os.uop.ingestion.rapi.component.LogsDataTransformer;
import com.os.uop.ingestion.rapi.model.ResourceLogsWrapper;
import com.os.uop.ingestion.rapi.repo.ResourceLogsWrapperRepo;
import io.opentelemetry.proto.collector.logs.v1.ExportLogsServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsDataService {

    @Autowired
    LogsDataTransformer logsDataTransformer;

    @Autowired
    ResourceLogsWrapperRepo resourceLogsWrapperRepo;

    public void writeLogs(ExportLogsServiceRequest logsData) {

        List<ResourceLogsWrapper> resourceLogsWrappers =
                logsDataTransformer.transformExportLogsServiceRequestToResourceLogsWrapper(logsData);

        resourceLogsWrappers.forEach(resourceLogsWrapperRepo::send);

    }

}
