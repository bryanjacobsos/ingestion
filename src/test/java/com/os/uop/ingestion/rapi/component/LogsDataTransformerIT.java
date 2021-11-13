package com.os.uop.ingestion.rapi.component;

import com.google.protobuf.util.JsonFormat;
import com.os.uop.ingestion.rapi.model.ResourceLogsWrapper;
import io.opentelemetry.proto.logs.v1.LogsData;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class LogsDataTransformerIT {

    @Autowired
    LogsDataTransformer logsDataTransformer;

    @Test
    public void letsseewhathappens() {

        List<ResourceLogsWrapper> resourceLogsWrappers =
                logsDataTransformer.transformLogsDataToResourceLogsWrapper(convertToLogsData());

        assertTrue(resourceLogsWrappers.size() == 5);
    }

    public static LogsData convertToLogsData() {

        LogsData.Builder logsDataBuilder = LogsData.newBuilder();

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
