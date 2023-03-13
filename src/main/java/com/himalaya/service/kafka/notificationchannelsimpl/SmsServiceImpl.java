package com.himalaya.service.kafka.notificationchannelsimpl;

import com.himalaya.service.kafka.notificationchannelsimpl.thirdpartyapi.SmsServiceApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl {

    private final SmsServiceApi service;

    public SmsServiceImpl(SmsServiceApi service) {
        this.service = service;
    }

    public boolean sendSms(String phoneNumber, String message){
        System.out.println("Message sent to: " + phoneNumber + ", message is: " + message);
        ResponseEntity<String> entity = service.sendSMS();
        return entity.getStatusCode() == HttpStatus.OK;
    }
}
