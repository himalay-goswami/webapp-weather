package com.himalaya.service.fetcherservice;

import com.himalaya.model.Weather;
import com.himalaya.model.WeatherDto;
import com.himalaya.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ResultService {

    @Autowired
    private ServiceA serviceA;
    @Autowired
    private ServiceB serviceB;

    @Autowired
    private WeatherService weatherService;

    @Scheduled(fixedRate = 10000)
    private void getMeanTemperature() throws ExecutionException, InterruptedException {
        double meanTemperature = weatherRetriever().get();
        Weather weather = new Weather();
        weather.setTemperature(meanTemperature);
        weather.setTimeStamp(LocalTime.now().toString());
        weather.setCityName("pune");
        System.out.println(weather);
        weatherService.saveWeatherData(weather);
    }

    private CompletableFuture<Double> weatherRetriever() {

        CompletableFuture<WeatherDto> WeatherDataSource1 = serviceA.getData();
        CompletableFuture<WeatherDto> WeatherDataSource2 = serviceB.getData();

        return WeatherDataSource1.thenCompose(
                (fd1Value) -> WeatherDataSource2
                        .thenApply((fd2Value) ->
                                fd1Value.temperature() + fd2Value.temperature()));
    }
}
