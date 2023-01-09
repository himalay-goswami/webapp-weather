package com.himalaya.service.datafetcher;

import com.himalaya.model.Weather;
import com.himalaya.model.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
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

  //  @Scheduled(fixedRate = 10000, initialDelay = 2000)
    public void getMeanTemperature() throws ExecutionException, InterruptedException {

        double meanTemperature = weatherRetriever().get();

        Weather weather = new Weather();
        weather.setTemperature(meanTemperature);
        weather.setUpdatedAt(LocalTime.now().toString());
        weather.setCityName("pune");

        System.out.println(weather);
    }

    public CompletableFuture<Double> weatherRetriever() {

        CompletableFuture<WeatherDto> WeatherDataSource1 = serviceA.getData();
        CompletableFuture<WeatherDto> WeatherDataSource2 = serviceB.getData();


        return WeatherDataSource1.thenCompose(
                (fd1Value) -> WeatherDataSource2.thenApply((fd2Value) -> fd1Value.temperature() + fd2Value.temperature()));
    }
}
