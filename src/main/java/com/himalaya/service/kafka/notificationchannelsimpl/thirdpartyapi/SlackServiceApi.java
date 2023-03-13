package com.himalaya.service.kafka.notificationchannelsimpl.thirdpartyapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SlackServiceApi {

    public ResponseEntity<String> sendSimpleMail(String to, String subject, String text){
        String MAIL_SENDER = "JavaMailSender";
        System.out.println("Mail sent via: "  + MAIL_SENDER + "Mail sent to: " + to + ", Subject: " + subject + ", Body = " + text);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
