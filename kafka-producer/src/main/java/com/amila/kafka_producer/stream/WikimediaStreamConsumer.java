package com.amila.kafka_producer.stream;

import com.amila.kafka_producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducer producer;

    public WikimediaStreamConsumer(WebClient.Builder webClient, WikimediaProducer producer) {
        this.webClient = webClient
                .baseUrl("https://stream.wikimedia.org/v2")
                .build();
        this.producer = producer;
    }

    public void consumeStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);

    }
}
