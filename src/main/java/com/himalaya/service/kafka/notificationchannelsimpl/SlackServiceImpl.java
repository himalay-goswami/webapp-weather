package com.himalaya.service.kafka.notificationchannelsimpl;

import com.himalaya.service.kafka.notificationchannelsimpl.thirdpartyapi.SlackServiceApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SlackServiceImpl {

    /*
    * Implementation class that makes use of service API to send the notification*/

    private final SlackServiceApi slackServiceApi;

    public SlackServiceImpl(SlackServiceApi slackServiceApi) {
        this.slackServiceApi = slackServiceApi;
    }

    public void sendMail(String email, String message, String text){
        ResponseEntity<String> responseEntity = slackServiceApi.sendSimpleMail(email, message, text);
        responseEntity.getStatusCode();
    }
}
