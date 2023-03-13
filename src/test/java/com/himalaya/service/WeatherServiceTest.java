package com.himalaya.service;

import com.himalaya.dao.impl.WeatherDaoImpl;
import com.himalaya.entity.Weather;
import com.himalaya.entity.shared.io.WeatherDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class WeatherServiceTest {

    @Test
    public void testWeatherService(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");

        WeatherDaoImpl weatherDao = mock(WeatherDaoImpl.class);
        CachedService cachedService = mock(CachedService.class);
        WeatherService weatherService = new WeatherService(weatherDao, cachedService);

        WeatherDto weather = new WeatherDto(1, "Pune", 36, formatter.format(LocalTime.now()));
        Weather weather1 = new Weather();
        BeanUtils.copyProperties(weather, weather1);

        when(weatherDao.getLatestData()).thenReturn(weather1);
        when(weatherService.getLatestCachedData()).thenReturn(weather);

        assertEquals(weather1, weatherDao.getLatestData());
        assertEquals(weather, cachedService.getLatestCachedData());

    }
}