package com.github.kafka.springbootkafka.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaListener {
    @org.springframework.kafka.annotation.KafkaListener(topics = "belajar-kafka", groupId = "groupid")
    public void listen(ConsumerRecord<String, String> csmRecord) {
        log.info("\u001b[35mRecive massage key [{}] with value \"{}\"\u001b[00m", csmRecord.key(), csmRecord.value(),
                csmRecord.headers());
    }
}
