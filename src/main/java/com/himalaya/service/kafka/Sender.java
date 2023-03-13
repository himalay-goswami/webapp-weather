package com.himalaya.service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender{

    private final KafkaTemplate<String, String> template;

    private static final String TOPIC = "notifications";

    public Sender(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    public void publishMessage(String message){
        this.template.send(TOPIC, message);
    }
}