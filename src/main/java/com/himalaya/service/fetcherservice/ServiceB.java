package com.himalaya.service.fetcherservice;

/*  */

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
    public CompletableFuture<Double> getData() {

        Double temperatureStub2 = fetcherService.fetchWeatherData(ConstantUtils.API_2);
        return CompletableFuture.completedFuture(temperatureStub2);

    }
}
