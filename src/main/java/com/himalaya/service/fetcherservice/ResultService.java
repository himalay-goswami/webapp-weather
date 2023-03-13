package com.himalaya.service.fetcherservice;

import com.himalaya.entity.shared.io.WeatherDto;
import com.himalaya.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationStartupAware;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class ResultService {

    //entry point for fetched data from the APIs. this class makes scheduled calls to
    //the APIs and stores weather data into database and cache after calculating mean temperature.

    @Autowired
    ServiceA serviceA;
    @Autowired
    ServiceB serviceB;

    @Autowired
    WeatherService weatherService;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss");
    @Async
    @Scheduled(fixedRate = 20000)
    @EventListener(ApplicationStartupAware.class)
    public void createWeatherEntity() throws ExecutionException, InterruptedException {

        WeatherDto weather = new WeatherDto();
        weather.setTemperature(getMeanTemperature());
        weather.setCityName("Pune");
        weather.setTimeStamp(formatter.format(LocalTime.now()));
        weatherService.saveWeatherData(weather);
    }

    public double getMeanTemperature() throws ExecutionException, InterruptedException {
        return weatherRetriever().get();
    }

    private CompletableFuture<Double> weatherRetriever() throws ExecutionException, InterruptedException {

        CompletableFuture<Double> WeatherDataSource1 = serviceA.getData();
        CompletableFuture<Double> WeatherDataSource2 = serviceB.getData();

        System.out.println(WeatherDataSource1.get() + ", " + WeatherDataSource2.get());

        return WeatherDataSource1.thenCompose(
                (fd1Value) -> WeatherDataSource2
                        .thenApply((fd2Value) ->
                                (fd1Value + fd2Value)/2));
    }
}
