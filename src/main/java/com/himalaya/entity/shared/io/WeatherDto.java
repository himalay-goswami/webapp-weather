package com.himalaya.entity.shared.io;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
@AllArgsConstructor
public class WeatherDto implements Serializable {

    private int id;
    private String cityName;
    private double temperature;
    private String timeStamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "WeatherDto{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
