package com.himalaya.service.fetcherservice;

import com.himalaya.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class ResultServiceTest {

    @Test
    public void testGetMeanTemperature() throws ExecutionException, InterruptedException {

        // Arrange
        double serviceAData = 25.0;
        double serviceBData = 30.0;
        double expectedMeanTemperature = (serviceAData + serviceBData) / 2;
        CompletableFuture<Double> completableFutureA = CompletableFuture.completedFuture(serviceAData);
        CompletableFuture<Double> completableFutureB = CompletableFuture.completedFuture(serviceBData);

        ServiceA serviceAMock = Mockito.mock(ServiceA.class);
        ServiceB serviceBMock = Mockito.mock(ServiceB.class);
        WeatherService weatherServiceMock = Mockito.mock(WeatherService.class);

        Mockito.when(serviceAMock.getData()).thenReturn(completableFutureA);
        Mockito.when(serviceBMock.getData()).thenReturn(completableFutureB);

        ResultService resultService = new ResultService();
        resultService.serviceA = serviceAMock;
        resultService.serviceB = serviceBMock;
        resultService.weatherService = weatherServiceMock;

        // Act
        double futureMeanTemperature = resultService.getMeanTemperature();
        CompletableFuture<Double> actualMeanTemperature = CompletableFuture.completedFuture(futureMeanTemperature);
        double finalTemp = actualMeanTemperature.get();


        // Assert
        assertEquals(expectedMeanTemperature, finalTemp, 0.001);
    }

}
