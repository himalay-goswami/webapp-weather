package com.himalaya.service;

import com.himalaya.entity.UserPref;
import com.himalaya.entity.shared.io.WeatherDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CachedServiceTest {


    @Test
    public void testCachedService(){

        CachedService cachedService = mock(CachedService.class);

        UserPref entity = new UserPref();
        doNothing().when(cachedService).savePreferences(entity);
        when(cachedService.getUserPreferenceEntity("test")).thenReturn(entity);

        WeatherDto weather = new WeatherDto();

        when(cachedService.getLatestCachedData()).thenReturn(weather);
        doNothing().when(cachedService).setWeatherCached(weather);
        assertEquals(weather, cachedService.getLatestCachedData());


    }

}