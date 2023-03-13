package com.himalaya.service.kafka.notificationchannelsimpl.thirdpartyapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceApi {

    /*This class contains code related to third party channels like sms services. For demonstration,
     I have made a simple print to console, and not implemented the actual call as it required further complexity.
    * */

    private final String ServiceName = "Twilio";

    public ResponseEntity<String> sendSMS() {

        //code to init() method sending and message creation.

        return new ResponseEntity<>("Message sent successfully", HttpStatus.OK);
    }
}
