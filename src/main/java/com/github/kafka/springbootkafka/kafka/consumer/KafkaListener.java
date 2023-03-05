package com.github.kafka.springbootkafka.kafka.consumer;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaListener {
    @org.springframework.kafka.annotation.KafkaListener(topics = "belajar-kafka", groupId = "groupid")
    public void listen(String massage) {
        log.info(massage);
    }
}
