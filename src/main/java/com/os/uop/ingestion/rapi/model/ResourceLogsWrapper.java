package com.os.uop.ingestion.rapi.model;

import io.opentelemetry.proto.logs.v1.ResourceLogs;

import java.util.Objects;
import java.util.UUID;

public class ResourceLogsWrapper {

    public static final String NOT_NULL = "resourceLogs must not be null";

    private ResourceLogs resourceLogs;

    private UUID uuid;

    public ResourceLogsWrapper(ResourceLogs resourceLogs, UUID uuid) {

        // TODO: finish all the validation logic

        Objects.requireNonNull(resourceLogs, NOT_NULL);


        Objects.requireNonNull(uuid, "uuid must not be null");

        this.resourceLogs = resourceLogs;

        this.uuid = uuid;

    }

    public String getUuidAsString() {
        return this.uuid.toString();
    }

    public ResourceLogs getResourceLogs() {
        return this.resourceLogs;
    }
}
