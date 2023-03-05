package com.github.kafka.springbootkafka.kafka.consumer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KafkaListener {
    @org.springframework.kafka.annotation.KafkaListener(id = "myListener", topics = "belajar-kafka")
    public void listen(String massage) {
        log.info(massage);
    }
}
