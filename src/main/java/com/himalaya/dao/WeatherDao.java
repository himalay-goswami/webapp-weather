package com.himalaya.dao;

import com.himalaya.entity.Weather;

public interface WeatherDao {

    /* the party */
    Weather getLatestData();

    void save(Weather weather);
}
