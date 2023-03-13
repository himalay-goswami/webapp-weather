package com.himalaya.service;

import com.himalaya.dao.WeatherDao;
import com.himalaya.entity.Weather;
import com.himalaya.entity.shared.io.WeatherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class WeatherService {

    /*
     * this class manages both the cache and dao operations for weather object. */

    private final WeatherDao weatherDao;

    private final CachedService cachedService;

    public WeatherService(WeatherDao weatherDao, CachedService cachedService) {
        this.weatherDao = weatherDao;
        this.cachedService = cachedService;
    }

    public void saveWeatherData(WeatherDto weather){
        cachedService.setWeatherCached(weather);
        Weather weatherEntity = new Weather();
        BeanUtils.copyProperties(weather, weatherEntity);
        weatherDao.save(weatherEntity);
    }

    public Weather getLatestData(){
        return weatherDao.getLatestData();
    }

    public WeatherDto getLatestCachedData(){
        return cachedService.getLatestCachedData();
    }

}
