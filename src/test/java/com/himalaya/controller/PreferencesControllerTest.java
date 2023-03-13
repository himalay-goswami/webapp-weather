package com.himalaya.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.concurrent.ExecutionException;

import com.himalaya.entity.UserPref;
import org.junit.Before;
import org.junit.Test;

import com.himalaya.entity.notification.Greeting;
import com.himalaya.entity.shared.io.UserPreferenceDto;
import com.himalaya.service.NotificationService;
import com.himalaya.service.UserPreferenceService;

public class PreferencesControllerTest {

    private PreferencesController preferencesController;
    private NotificationService notificationService;

    private UserPreferenceService userPreferenceService;

    @Before
    public void setup() {
        userPreferenceService = mock(UserPreferenceService.class);
        notificationService = mock(NotificationService.class);
        preferencesController = new PreferencesController(userPreferenceService, notificationService);
    }

    @Test
    public void testGreeting() throws ExecutionException, InterruptedException {

        UserPreferenceDto entity = new UserPreferenceDto(11, 11);
        UserPref userPref = new UserPref();
        Greeting result = new Greeting("Temperature Changed.");

        doNothing().when(userPreferenceService).savePreferences(entity);
        when(userPreferenceService.getUserPreferenceEntity("pune")).thenReturn(entity);

        when(notificationService.checkForConditionFulfilment(any(UserPreferenceDto.class))).thenReturn(true);

        assert(result.getMessage().equals("Temperature Changed."));
    }
}
