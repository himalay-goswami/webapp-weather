package com.himalaya.model;


public class WeatherDto {

    private long id;
    private String name;
    private double temperature;

    public long id() {
        return id;
    }

    public WeatherDto setId(long id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public WeatherDto setName(String name) {
        this.name = name;
        return this;
    }

    public double temperature() {
        return temperature;
    }

    public WeatherDto setTemperature(double temperature) {
        this.temperature = temperature;
        return this;
    }
}
