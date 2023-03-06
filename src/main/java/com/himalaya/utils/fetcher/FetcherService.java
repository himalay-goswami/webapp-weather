package com.himalaya.utils.fetcher;

import com.himalaya.model.WeatherDto;
import org.springframework.stereotype.Component;

@Component
public interface FetcherService {

    WeatherDto fetchWeatherData(String uri);
}
