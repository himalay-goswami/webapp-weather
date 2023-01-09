package com.himalaya.service;


import com.himalaya.dao.WeatherDao;
import com.himalaya.model.Weather;
import com.himalaya.model.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//this class will persist data to database by calling the dao
@Service
public class WeatherService {

    @Autowired
    private WeatherDao weatherDao;

    public void saveWeatherData(Weather weather){
        weatherDao.save(weather);
    }

    public WeatherDto getLatestData(){
        return weatherDao.getLatestData();

    }

}
