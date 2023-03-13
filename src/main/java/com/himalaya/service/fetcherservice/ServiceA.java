package com.himalaya.service.fetcherservice;

import com.himalaya.utils.ConstantUtils;
import com.himalaya.utils.fetcher.FetcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ServiceA {

    /*
    * Fetcher class to get data from APIs. This class makes use of a util HTTPClient
    * class to do the job.*/

    @Autowired
    private FetcherService fetcherService;

    @Async
    public CompletableFuture<Double> getData() {

        Double temperatureStub1 = fetcherService
                .fetchWeatherData(ConstantUtils.API_1);
        return CompletableFuture.completedFuture(temperatureStub1);
    }


}
