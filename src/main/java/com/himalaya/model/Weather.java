package com.himalaya.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Weather {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "cityName")
    private String cityName;
    @Column(name = "temperature")
    private double temperature;

    @Column(name = "updatedAt")
    private String updatedAt;

    public int getId() {
        return id;
    }

    public int id() {
        return id;
    }

    public Weather setId(int id) {
        this.id = id;
        return this;
    }

    public String cityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double temperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String updatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
