package com.himalaya.service;

import com.himalaya.entity.shared.io.UserPreferenceDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class UserPreferenceServiceTest {


    @Test
    public void testUserPreferences(){

        UserPreferenceService service = Mockito.mock(UserPreferenceService.class);
        UserPreferenceDto entity = new UserPreferenceDto(12, 21);
        Mockito.when(service.getUserPreferenceEntity("pune")).thenReturn(entity);
    }
}