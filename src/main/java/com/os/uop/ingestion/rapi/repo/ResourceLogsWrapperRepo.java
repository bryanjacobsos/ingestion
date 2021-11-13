package com.os.uop.ingestion.rapi.repo;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.os.uop.ingestion.rapi.model.ResourceLogsWrapper;
import io.opentelemetry.proto.logs.v1.ResourceLogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Repository
public class ResourceLogsWrapperRepo {

    private static final Logger LOG = LoggerFactory.getLogger(ResourceLogsWrapperRepo.class);

    @Value("${spring.kafka.template.default-topic}")
    String topic;

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void send(ResourceLogsWrapper resourceLogsWrapper) {

        ResourceLogs resourceLogs = resourceLogsWrapper.getResourceLogs();

        try {

            String jsonResourceLogs = JsonFormat.printer().print(resourceLogs);

            ListenableFuture future = kafkaTemplate.send(topic, jsonResourceLogs);

            future.addCallback(new ListenableFutureCallback() {
                @Override
                public void onFailure(Throwable ex) {
                    LOG.error("Unable to send message to kafka. Failed message: {}", jsonResourceLogs);
                }

                @Override
                public void onSuccess(Object result) {
                    // NOOP...just get it done
                }
            });

        } catch (InvalidProtocolBufferException e) {
            LOG.error("unable to convert protobuf to json calling toString on ResourceLog {}", resourceLogs);
        }

    }
}
