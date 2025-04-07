package org.example.demo.producer;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final ProducerService producer;

    @PostMapping("/publish")
    public void publishMessage(@RequestBody JsonNode message) {
        producer.publish(message);
    }

}