package com.himalaya.utils.fetcher.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.himalaya.utils.fetcher.FetcherService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class FetcherServiceImpl implements FetcherService {

    private double temperature;

    @Override
    public double fetchWeatherData(String uri) {

        HttpClient client;
        HttpRequest request;
        HttpResponse<String> response;
        ObjectMapper mapper = new ObjectMapper();

        try {
            client = HttpClient.newHttpClient();
            request = HttpRequest.newBuilder()
                    .GET()
                    .header("accept", "application/json")
                    .uri(URI.create(uri))
                    .build();
                try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            }
            catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                temperature = mapper.readValue(response.body(), new TypeReference<>() {});
            }
            catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            System.out.println(temperature);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return temperature;
    }
}
