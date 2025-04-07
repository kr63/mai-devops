package org.example.demo.consumer;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.config.SaslConfigs;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Slf4j
@EnableKafka
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MyKafkaProperties.class)
public class KafkaConsumerConfig {

    private final KafkaProperties builder;
    private final MyKafkaProperties properties;

    @Bean
    JsonMessageConverter jsonbMessageConverter() {
        return new JsonMessageConverter();
    }

    @Bean
    public ConsumerFactory<String, JsonNode> consumerFactory() {
        var config = builder.buildConsumerProperties();

        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        config.put(ErrorHandlingDeserializer.KEY_DESERIALIZER_CLASS, StringDeserializer.class);
        config.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, StringDeserializer.class);

        config.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, properties.getSecurityProtocol());

        config.put(SaslConfigs.SASL_MECHANISM, properties.getSaslMechanism());
        config.put(SaslConfigs.SASL_JAAS_CONFIG, properties.getSaslJaasConfig());

        return new DefaultKafkaConsumerFactory<>(
                config, new StringDeserializer(),
                new JsonDeserializer<>(JsonNode.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, JsonNode> containerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, JsonNode>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
