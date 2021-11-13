package com.os.uop.ingestion.rapi.component;

import com.google.protobuf.util.JsonFormat;
import com.os.uop.ingestion.rapi.model.ResourceLogsWrapper;
import io.opentelemetry.proto.collector.logs.v1.ExportLogsServiceRequest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class ExportLogsServiceRequestTransformerIT {

    @Autowired
    ExportLogsServiceRequestTransformer logsDataTransformer;

    @Test
    public void shouldHaveFiveResourceLogsWrappers() {

        List<ResourceLogsWrapper> resourceLogsWrappers =
                logsDataTransformer.transformExportLogsServiceRequestToResourceLogsWrapper(convertToLogsData());

        assertTrue(resourceLogsWrappers.size() == 5);
    }

    public static ExportLogsServiceRequest convertToLogsData() {

        ExportLogsServiceRequest.Builder logsDataBuilder = ExportLogsServiceRequest.newBuilder();

        try {

            File file = ResourceUtils.getFile("classpath:LogsData.json");

            String dataLogsJson = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

            JsonFormat.parser().ignoringUnknownFields().merge(dataLogsJson, logsDataBuilder);

            return logsDataBuilder.build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
