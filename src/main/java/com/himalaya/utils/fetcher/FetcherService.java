package com.himalaya.utils.fetcher;

import org.springframework.stereotype.Component;

@Component
public interface FetcherService {

    double fetchWeatherData(String uri);
}
