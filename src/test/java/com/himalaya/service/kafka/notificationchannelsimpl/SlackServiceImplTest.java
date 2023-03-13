package com.himalaya.service.kafka.notificationchannelsimpl;

import com.himalaya.service.kafka.notificationchannelsimpl.thirdpartyapi.SlackServiceApi;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class SlackServiceImplTest {

    @Test
    void sendMail() {
        SlackServiceApi slackServiceApi = Mockito.mock(SlackServiceApi.class);

        SlackServiceImpl service = new SlackServiceImpl(slackServiceApi);
        String phoneNumber = "number";
        String message = "message";
        Mockito.when(slackServiceApi.sendSimpleMail(phoneNumber, message, "hi"))
                .thenReturn(new ResponseEntity<>(HttpStatus.OK));
    }
}