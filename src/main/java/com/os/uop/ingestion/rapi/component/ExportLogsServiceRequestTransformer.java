package com.os.uop.ingestion.rapi.component;

import com.os.uop.ingestion.rapi.model.ResourceLogsWrapper;
import io.opentelemetry.proto.collector.logs.v1.ExportLogsServiceRequest;
import io.opentelemetry.proto.common.v1.InstrumentationLibrary;
import io.opentelemetry.proto.logs.v1.InstrumentationLibraryLogs;
import io.opentelemetry.proto.logs.v1.LogRecord;
import io.opentelemetry.proto.logs.v1.ResourceLogs;
import io.opentelemetry.proto.resource.v1.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ExportLogsServiceRequestTransformer {

    public List<ResourceLogsWrapper> transformExportLogsServiceRequestToResourceLogsWrapper(ExportLogsServiceRequest exportLogsServiceRequest) {

        List<ResourceLogs> resourceLogsList = exportLogsServiceRequest.getResourceLogsList();

        List<ResourceLogsWrapper> resourceLogsWrappers = new ArrayList<>();

        resourceLogsList.forEach(resourceLogs -> {

            Resource resource = resourceLogs.getResource();

            resourceLogs.getInstrumentationLibraryLogsList().forEach(instrumentationLibraryLogs -> {

                List<LogRecord> logRecords = instrumentationLibraryLogs.getLogsList();

                UUID uuid = UUID.randomUUID();

                logRecords.forEach(logRecord -> {

                    InstrumentationLibrary instrumentationLibrary = instrumentationLibraryLogs.getInstrumentationLibrary();

                    InstrumentationLibraryLogs.Builder instrumentationLibraryLogsBuilder = InstrumentationLibraryLogs.newBuilder();

                    instrumentationLibraryLogsBuilder.setInstrumentationLibrary(instrumentationLibrary);

                    instrumentationLibraryLogsBuilder.addLogs(logRecord);

                    ResourceLogs.Builder expandedResourceLogsBuilder = ResourceLogs.newBuilder()
                            .setResource(resource)
                            .addInstrumentationLibraryLogs(instrumentationLibraryLogsBuilder);

                    resourceLogsWrappers.add(new ResourceLogsWrapper(expandedResourceLogsBuilder.build(), uuid));
                });
            });
        });

        return resourceLogsWrappers;
    }

}
