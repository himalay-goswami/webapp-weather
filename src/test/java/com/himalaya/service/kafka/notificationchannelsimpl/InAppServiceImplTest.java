package com.himalaya.service.kafka.notificationchannelsimpl;

import com.himalaya.entity.notification.Greeting;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.messaging.simp.SimpMessagingTemplate;

class InAppServiceImplTest {

    @Test
    void sendMessage() {
        SimpMessagingTemplate simpMessagingTemplate = Mockito.mock(SimpMessagingTemplate.class);
        InAppServiceImpl inAppServiceApi = new InAppServiceImpl(simpMessagingTemplate);

        Greeting greeting = new Greeting("hello");
        Mockito.doNothing().when(simpMessagingTemplate).convertAndSend(greeting);

    }


}

