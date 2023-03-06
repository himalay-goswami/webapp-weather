package com.himalaya.model;


public class WeatherDto {

    private int id;
    private String cityName;
    private double temperature;
    private String timeStamp;

    public String timeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String name() {
        return cityName;
    }

    public void setName(String name) {
        this.cityName = name;
    }

    public double temperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
