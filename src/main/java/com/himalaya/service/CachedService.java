package com.himalaya.service;

import com.himalaya.entity.UserPref;
import com.himalaya.entity.shared.io.WeatherDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Cacheable({"preference", "weather"})
public class CachedService {

    /*
    * this class is responsible for caching, based on configuration in config package.
    * For more clarity, I am saving values in an in-memory list, and caching the values.
    * Database call is made only if the cache is not available. */

    private WeatherDto weatherCached;

    private final Map<String, UserPref> entityPreferences;

    public CachedService() {
        this.entityPreferences = new HashMap<>();
        weatherCached = new WeatherDto();
    }

    public void savePreferences(UserPref preference){
        entityPreferences.put("Pune", preference);
    }

    @CachePut("preference")
    @CacheEvict(value="preference", allEntries=true)
    public UserPref getUserPreferenceEntity(String city) {
        return entityPreferences.get(city);
    }

    public void setWeatherCached(WeatherDto weatherCached) {
        this.weatherCached = weatherCached;
    }

    @CachePut("weather")
    @CacheEvict(value="weather", allEntries=true)
    public WeatherDto getLatestCachedData(){
        return weatherCached;
    }
}
