package com.himalaya.service.fetcherservice;

import com.himalaya.model.WeatherDto;
import com.himalaya.utils.ConstantUtils;
import com.himalaya.utils.fetcher.FetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ServiceA {

    @Autowired
    private FetcherService fetcherService;

    @Async
    public CompletableFuture<WeatherDto> getData() {

        WeatherDto weatherDto = fetcherService
                .fetchWeatherData(ConstantUtils.GRAPHQL_API_URL_1);

        return CompletableFuture.completedFuture(weatherDto);
    }


}
