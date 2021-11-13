package com.os.uop.ingestion.rapi.rest;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import io.opentelemetry.proto.logs.v1.ResourceLogs;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Component
public class LogsRestConsumerIT {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

    public static final int NUMBER_OF_RESOURCE_LOGS = 5;

    private CountDownLatch latch = new CountDownLatch(NUMBER_OF_RESOURCE_LOGS);

    private List<ResourceLogs> resourceLogsList = new ArrayList<>();

    @KafkaListener(topics = "${spring.kafka.template.default-topic}")
    public void receive(ConsumerRecord<String, String> consumerRecord) throws InvalidProtocolBufferException {

        LOG.info("TEST payload='{}'", consumerRecord.toString());

        ResourceLogs.Builder builder = ResourceLogs.newBuilder();

        JsonFormat.parser().merge(consumerRecord.value(), builder);

        resourceLogsList.add(builder.build());

        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public List<ResourceLogs> getCollectedResourceLogs() {
        return resourceLogsList;
    }

}
