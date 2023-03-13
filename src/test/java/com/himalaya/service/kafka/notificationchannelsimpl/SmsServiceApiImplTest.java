package com.himalaya.service.kafka.notificationchannelsimpl;

import com.himalaya.service.kafka.notificationchannelsimpl.thirdpartyapi.SmsServiceApi;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class SmsServiceApiImplTest {

    @Test
    void testSendSms() {

        SmsServiceApi smsServiceApi = Mockito.mock(SmsServiceApi.class);

        SmsServiceImpl service = new SmsServiceImpl(smsServiceApi);
        String phoneNumber = "number";
        String message = "message";
        Mockito.when(smsServiceApi.sendSMS()).thenReturn(new ResponseEntity<>(HttpStatus.OK));

        assertTrue(service.sendSms(phoneNumber, message));
    }
}