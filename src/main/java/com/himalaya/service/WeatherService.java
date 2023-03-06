package com.himalaya.service;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.himalaya.dao.WeatherDao;
import com.himalaya.model.Weather;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//this class will persist data to database by calling the dao
@Service
@Slf4j
@JsonIgnoreProperties
public class WeatherService {

    Logger logger = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    private WeatherDao weatherDao;


    @CachePut(value = "temperature")
    @Transactional
    public void saveWeatherData(Weather weather){
        logger.info("Saving data to db");
        System.out.println("Saving data to db...");
        weatherDao.save(weather);
    }

    @Transactional
    public Weather getLatestData(){
        logger.info(String.valueOf(weatherDao.getLatestData()));
        return weatherDao.getLatestData();
    }
}
