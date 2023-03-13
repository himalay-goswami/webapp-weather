package com.himalaya.service.kafka.notificationchannelsimpl;

import com.himalaya.entity.notification.Greeting;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class InAppServiceImpl {

    /*
    * this class sends a message back to the client who's subscribed to the topic using web socket*/

    private final SimpMessagingTemplate simpMessagingTemplate;

    public InAppServiceImpl(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendMessage(String message) {
        simpMessagingTemplate.convertAndSend("/topic/greetings", new Greeting(message));
    }


}
