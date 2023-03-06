package com.himalaya.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "Weather", schema = "weather_data")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "cityName")
    private String cityName;
    @Column(name = "temperature")
    private double temperature;

    @Column(name = "timeStamp")
    private String timeStamp;

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
        return timeStamp;
    }

    public void setTimeStamp(String updatedAt) {
        this.timeStamp = updatedAt;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", temperature=" + temperature +
                ", updatedAt='" + timeStamp + '\'' +
                '}';
    }
}
