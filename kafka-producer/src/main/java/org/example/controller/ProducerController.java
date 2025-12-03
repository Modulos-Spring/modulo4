package org.example.controller;

import org.example.entity.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/msn")
public class ProducerController {

    @Value("${spring.kafka.topic}")
    private String topicName;

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public ProducerController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sendMessage(@RequestBody Message message) {
        kafkaTemplate.send(topicName, UUID.randomUUID().toString(), message);
        return message.messageContent();
    }
}
