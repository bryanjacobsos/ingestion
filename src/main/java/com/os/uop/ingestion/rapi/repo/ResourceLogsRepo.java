package com.os.uop.ingestion.rapi.repo;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import io.opentelemetry.proto.logs.v1.ResourceLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ResourceLogsRepo {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceLogsRepo.class);

    @Value("${kafka.topic}")
    String topic;

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void send(ResourceLogs resourceLogs) {

        try {

            String jsonResourceLogs = JsonFormat.printer().print(resourceLogs);

            kafkaTemplate.send(topic, jsonResourceLogs);

        } catch (InvalidProtocolBufferException e) {
            LOG.error("unable to convert protobuf to json calling toString on ResourceLog {}", resourceLogs);
        }

    }
}
