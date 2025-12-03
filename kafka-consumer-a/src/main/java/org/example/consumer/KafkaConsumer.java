package org.example.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.entity.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.TopicSuffixingStrategy;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    @RetryableTopic(
            autoCreateTopics = "false",
            backoff = @Backoff(
                    delay = 15000,
                    multiplier = 2.0,
                    maxDelay = 54000),
            topicSuffixingStrategy = TopicSuffixingStrategy.SUFFIX_WITH_INDEX_VALUE
    )
    @KafkaListener(
            topics = "${spring.kafka.topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerFactory"
    )

    public void listener(ConsumerRecord<String, Message> record) {
        System.out.println("** Nova mensagem recebida **");
        System.out.println("KEY: " + record.key());
        System.out.println("VALUE: " + record.value().messageContent());
        System.out.println("====================================");
    }
}
