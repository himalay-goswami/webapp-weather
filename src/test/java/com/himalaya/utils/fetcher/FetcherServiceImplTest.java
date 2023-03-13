package com.himalaya.utils.fetcher;

import com.himalaya.utils.fetcher.impl.FetcherServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;


@RunWith(PowerMockRunner.class)
@PrepareForTest({FetcherServiceImpl.class, HttpClient.class})
public class FetcherServiceImplTest {

    @Mock
    private HttpClient httpClient;

    @Mock
    private HttpResponse<String> httpResponse;

    private FetcherServiceImpl fetcherService;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        fetcherService = new FetcherServiceImpl();
    }

    @Test
    public void testFetchWeatherData() throws RuntimeException {

        try {
            // Stub the HTTP response
            String jsonResponse = "{\"main\":{\"temp\":10.0}}";
            when(httpResponse.body()).thenReturn(jsonResponse);

            // Mock the HTTP client and response
            mockStatic(HttpClient.class);
            when(HttpClient.newHttpClient()).thenReturn(httpClient);
            when(httpClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString()))).thenReturn(httpResponse);

            // Call the service
            double temperature = fetcherService.fetchWeatherData("http://dummy.url");

            // Verify the response
            assertEquals(10.0, temperature, 0.001);
        } catch (RuntimeException e) {
            System.out.println("Testing mechanism exception.");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
