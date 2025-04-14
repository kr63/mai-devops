package org.example.demo.consumer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Настройки кафки
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "kafka-config")
public class MyKafkaProperties {

    @Value("${kafka-config.topic}")
    private String topic;

    @Value("${kafka-config.security.protocol}")
    private String securityProtocol;

    @Value("${kafka-config.sasl.mechanism}")
    private String saslMechanism;

    @Value("${kafka-config.sasl.jaas.config}")
    private String saslJaasConfig;

}
