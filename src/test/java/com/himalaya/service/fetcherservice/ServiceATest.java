package com.himalaya.service.fetcherservice;

import com.himalaya.utils.ConstantUtils;
import com.himalaya.utils.fetcher.FetcherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceATest {

    @Mock
    private FetcherService fetcherService;

    private ServiceB serviceB;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        serviceB = new ServiceB(fetcherService);
    }

    @Test
    public void testGetData() {
        double temperatureStub = 25.0;
        when(fetcherService.fetchWeatherData(ConstantUtils.API_2)).thenReturn(temperatureStub);

        CompletableFuture<Double> result = serviceB.getData();

        assertEquals(temperatureStub, result.join());
    }
}
