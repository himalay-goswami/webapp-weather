package com.himalaya.service.fetcherservice;

/*  */

import com.himalaya.model.WeatherDto;
import com.himalaya.utils.ConstantUtils;
import com.himalaya.utils.fetcher.FetcherService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ServiceB {

    private final FetcherService fetcherService;

    public ServiceB(FetcherService fetcherService) {
        this.fetcherService = fetcherService;
    }

    @Async
    public CompletableFuture<WeatherDto> getData() {

        WeatherDto weatherDto = fetcherService.fetchWeatherData(ConstantUtils.GRAPHQL_API_URL_2);
        return CompletableFuture.completedFuture(weatherDto);

    }
}
