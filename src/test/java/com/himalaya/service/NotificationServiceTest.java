package com.himalaya.service;

import com.himalaya.entity.shared.io.UserPreferenceDto;
import com.himalaya.service.fetcherservice.ResultService;
import com.himalaya.service.kafka.Sender;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NotificationServiceTest {


    @Test
    public void testNotificationService() throws ExecutionException, InterruptedException {

        UserPreferenceService service = Mockito.mock(UserPreferenceService.class);
        ResultService resultService = Mockito.mock(ResultService.class);
        Sender sender = Mockito.mock(Sender.class);

        NotificationService notificationService  = new NotificationService(sender, resultService, service);

        UserPreferenceDto userPreferenceDto = new UserPreferenceDto();

        double meanTemperature = 25;

        Mockito.when(resultService.getMeanTemperature()).thenReturn(meanTemperature);
        Mockito.when(service.getUserPreferenceEntity("pune")).thenReturn(userPreferenceDto);

        assertTrue((meanTemperature>userPreferenceDto.getName()) ||
                meanTemperature<userPreferenceDto.getValue());

    }
}