package com.example.weatherservice.controller;

import com.example.weatherservice.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public Map<String, Object> getWeatherAverages(@RequestParam("cityName") String cityName, @RequestParam("countryCode") String countryCode) {
        return weatherService.calculateAverages(cityName,countryCode);
    }
}