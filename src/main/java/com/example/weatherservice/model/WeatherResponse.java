package com.example.weatherservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WeatherResponse {
    @JsonProperty("list")
    List<WeatherInfo> weatherInfoList;

    public List<WeatherInfo> getWeatherInfoList() {
        return weatherInfoList;
    }

    public void setWeatherInfoList(List<WeatherInfo> weatherInfoList) {
        this.weatherInfoList = weatherInfoList;
    }
}
