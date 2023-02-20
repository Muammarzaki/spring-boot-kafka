package com.github.kafka.springbootkafka.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class KafkaProperties {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    /**
     * @return the bootstrapAddress
     */
    public String getBootstrapAddress() {
        return bootstrapAddress;
    }

}
