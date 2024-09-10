package com.amila.kafka_consumer.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@Slf4j
public class WikimediaConsumer {

    @KafkaListener(topics = "wikimediaTopic", groupId = "myGroup")
    public void consumeWikimedia(String msg){
        log.info(format("Consuming the message from wikimedia topic:: %s", msg));

        // please fell free to do anything you want to data
    }
}
