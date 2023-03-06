package com.github.kafka.springbootkafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;

import com.github.kafka.springbootkafka.kafka.producer.KafkaPublisher;

@SpringBootApplication
@EnableKafka
@EnableConfigurationProperties
public class SpringBootKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKafkaApplication.class, args);
	}

	@Bean
	public CommandLineRunner initRunner(KafkaPublisher kafkaPublisher) {

		return args -> {
			String topic = "belajar-kafka";
			kafkaPublisher.publish(topic, "ping");
		};
	}
}
