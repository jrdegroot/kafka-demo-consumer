package com.example.kafkademoconsumer;

import com.example.kafkademoconsumer.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageConsumer {

    public final static String DEMO_TOPIC = "demo-topic";

    @KafkaListener(topics = DEMO_TOPIC)
    public void on(@Payload User user, @Header(KafkaHeaders.RECEIVED_PARTITION) String partition,
                   @Header(KafkaHeaders.RECEIVED_KEY) String key) {
        log.info("Consumed from partition: {} key: {} user: {}", partition, key, user);
    }
}
