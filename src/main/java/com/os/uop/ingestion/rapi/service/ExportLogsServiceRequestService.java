package com.os.uop.ingestion.rapi.service;

import com.os.uop.ingestion.rapi.component.ExportLogsServiceRequestTransformer;
import com.os.uop.ingestion.rapi.model.ResourceLogsWrapper;
import com.os.uop.ingestion.rapi.repo.ResourceLogsWrapperRepo;
import io.opentelemetry.proto.collector.logs.v1.ExportLogsServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExportLogsServiceRequestService {

    @Autowired
    ExportLogsServiceRequestTransformer exportLogsServiceRequestTransformer;

    @Autowired
    ResourceLogsWrapperRepo resourceLogsWrapperRepo;

    public void writeLogs(ExportLogsServiceRequest logsData) {

        List<ResourceLogsWrapper> resourceLogsWrappers =
                exportLogsServiceRequestTransformer.transformExportLogsServiceRequestToResourceLogsWrapper(logsData);

        resourceLogsWrappers.forEach(resourceLogsWrapperRepo::send);

    }

}
