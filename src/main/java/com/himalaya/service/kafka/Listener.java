package com.himalaya.service.kafka;

import com.himalaya.service.kafka.notificationchannelsimpl.SlackServiceImpl;
import com.himalaya.service.kafka.notificationchannelsimpl.SmsServiceImpl;
import com.himalaya.service.kafka.notificationchannelsimpl.InAppServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener{

    @Autowired
    SlackServiceImpl emailService;
    @Autowired
    SmsServiceImpl smsService;

    @Autowired
    InAppServiceImpl inAppServiceImpl;

    @KafkaListener(groupId = "notificationChannels", topics = "notifications")
    public void notificationConsumer(String message) {
        System.out.println(message);
        emailService.sendMail("himalay@example.com", message, "hello");
        smsService.sendSms("9129160777", message);
        inAppServiceImpl.sendMessage(message);
    }

}