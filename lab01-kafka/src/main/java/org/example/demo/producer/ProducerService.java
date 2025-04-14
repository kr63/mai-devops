package org.example.demo.producer;

import java.util.UUID;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.consumer.MyKafkaProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProducerService {

    private final KafkaTemplate<UUID, JsonNode> kafkaTemplate;
    private final MyKafkaProperties properties;

    public void publish(JsonNode message) {
        var key = UUID.randomUUID();
        kafkaTemplate.send(properties.getTopic(), key,message);
        log.info(">>> Publish message: {}, key: {}", message, key);
    }

}
