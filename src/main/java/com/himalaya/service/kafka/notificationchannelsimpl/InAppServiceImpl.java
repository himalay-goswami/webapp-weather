package com.himalaya.service.kafka.notificationchannelsimpl;

import com.himalaya.entity.notification.Greeting;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class InAppServiceImpl {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public InAppServiceImpl(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendMessage(String message) {
        simpMessagingTemplate.convertAndSend("/topic/greetings", new Greeting(message));
    }


}
