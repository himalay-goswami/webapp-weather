
package com.himalaya.service.kafka;

import com.himalaya.service.kafka.notificationchannelsimpl.SlackServiceImpl;
import com.himalaya.service.kafka.notificationchannelsimpl.SmsServiceImpl;
import com.himalaya.service.kafka.notificationchannelsimpl.InAppServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListenerTest {

    private Listener listener;
    @Mock
    SlackServiceImpl emailService;
    @Mock
    private SmsServiceImpl smsService;

    @Mock
    private InAppServiceImpl inAppServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        listener = new Listener();
        listener.emailService = emailService;
        listener.smsService = smsService;
        listener.inAppServiceImpl = inAppServiceImpl;
    }

    @Test
    public void testNotificationConsumer() {
        String message = "test message";
        listener.notificationConsumer(message);
        verify(emailService, times(1)).sendMail(anyString(), eq(message), anyString());
        verify(smsService, times(1)).sendSms(anyString(), eq(message));
        verify(inAppServiceImpl, times(1)).sendMessage(message);
    }
}