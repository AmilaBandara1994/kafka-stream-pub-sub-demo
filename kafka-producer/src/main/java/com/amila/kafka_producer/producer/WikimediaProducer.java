package com.amila.kafka_producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
@RequiredArgsConstructor
public class WikimediaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String msg){
        log.info(format("Sending message to wikimedia topic:: %s", msg));
        kafkaTemplate.send("wikimediaTopic", msg);
    }
}
