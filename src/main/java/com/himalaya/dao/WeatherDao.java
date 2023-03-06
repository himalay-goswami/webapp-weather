package com.himalaya.dao;

import com.himalaya.model.Weather;

public interface WeatherDao {

    /* the party */
    public Weather getLatestData();

    public void save(Weather weather);
}
