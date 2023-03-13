package com.himalaya.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
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
