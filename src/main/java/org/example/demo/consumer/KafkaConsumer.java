package org.example.demo.consumer;

import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    @KafkaListener(
            topics = "${kafka-config.topic}",
            containerFactory = "containerFactory"
    )
    public void process(@Payload JsonNode payload,
                        @Header(KafkaHeaders.RECEIVED_KEY) UUID key,
                        @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                        @Header(KafkaHeaders.OFFSET) int offset) {

        log.info(">>> Received message: {}", payload);
        log.info(">>> key: {}, partition: {}, offset: {}", key, partition, offset);
    }

}
