package com.github.kafka.springbootkafka.kafka.producer;

import java.util.concurrent.CompletableFuture;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class KafkaPublisher {

    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * @param kafkaTemplate
     */
    public KafkaPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(String topic, String key, Object data) {
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, key, data);
        future.whenCompleteAsync((result, ex) -> {
            if (ex == null) {
                log.info("\u001b[32msend to topic {} with key {} success :: {}\u001b[00m", topic, key,
                        result.getProducerRecord().getClass());
            } else {
                log.info("\u001b[31msend to topic {} with key {} failur :: {}", topic, key,
                        ex.getCause().getMessage());
            }
        });
    }

}
