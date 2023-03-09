package com.github.kafka.springbootkafka.kafka.admintclient;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import com.github.kafka.springbootkafka.kafka.KafkaProperties;

import lombok.extern.slf4j.Slf4j;

/**
 * kafakConfig
 */
@Configuration
@Slf4j
public class KafakAdminConfig {
    private KafkaProperties kafkaProperties;

    /**
     * @param kafkaProperties
     */
    public KafakAdminConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public KafkaAdmin kafakAdmin() {
        Map<String, Object> kafkaAdminconfig = new HashMap<>();
        kafkaAdminconfig.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapAddress());
        log.info("kafka AdminClient use ip {}", kafkaProperties.getBootstrapAddress());
        return new KafkaAdmin(kafkaAdminconfig);
    }

    @Bean
    public NewTopic topicConfig() {
        return TopicBuilder.name("belajar-kafka")
                .partitions(2).compact()
                .build();
    }
}