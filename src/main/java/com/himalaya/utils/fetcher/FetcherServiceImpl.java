package com.himalaya.utils.fetcher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.himalaya.model.WeatherDto;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class FetcherServiceImpl implements FetcherService {

    WeatherDto weatherDto;

    @Override
    public WeatherDto fetchWeatherData(String uri) {

        HttpResponse<String> response;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create(uri))
                    .build();
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            ObjectMapper mapper = new ObjectMapper();

            try {
                weatherDto = mapper.readValue(response.body(), new TypeReference<>() {
                });
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            System.out.println(weatherDto);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return weatherDto;
    }
}
