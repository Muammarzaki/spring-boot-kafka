package com.github.kafka.springbootkafka.controllers;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.kafka.springbootkafka.kafka.producer.KafkaPublisher;

/**
 * MassageController
 */
@RestController
@RequestMapping("api")
public class MassageController {
    private KafkaPublisher kafkaPublisher;
    private NewTopic topic;

    /**
     * @param kafkaPublisher
     * @param topic
     */
    public MassageController(KafkaPublisher kafkaPublisher, NewTopic topic) {
        this.kafkaPublisher = kafkaPublisher;
        this.topic = topic;
    }

    @GetMapping("massage")
    public ResponseEntity<String> sendMassage(@RequestParam String massage) {
        kafkaPublisher.publish(topic.name(), massage);
        return ResponseEntity.ok().body("Success");
    }

}