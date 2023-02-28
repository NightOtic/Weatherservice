package com.example.weatherservice.service;

import com.example.weatherservice.model.WeatherData;
import com.example.weatherservice.model.WeatherInfo;
import com.example.weatherservice.model.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class WeatherService {

    private RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<WeatherData> getWeatherData(String cityName, String countryCode) {
        String url = "https://samples.openweathermap.org/data/2.5/forecast?q=" + cityName + "," + countryCode + "&appid=b6907d289e10d714a6e88b30761fae22";
        ResponseEntity<WeatherResponse> responseEntity = restTemplate.getForEntity(url, WeatherResponse.class);
        WeatherResponse weatherResponse = responseEntity.getBody();
        List<WeatherData> weatherDataList = new ArrayList<>();

        // Extract the required data from the response and add it to the weatherDataList
        for (WeatherInfo weatherInfo : weatherResponse.getWeatherInfoList()) {
            WeatherData weatherData = new WeatherData();
            weatherData.setTemperature(weatherInfo.getMain().getTemp());
            weatherData.setHumidity(weatherInfo.getMain().getHumidity());
            weatherData.setPressure(weatherInfo.getMain().getPressure());
            weatherDataList.add(weatherData);
        }

        return weatherDataList;
    }

    public Map<String, Object> calculateAverages(String cityName, String countryCode) {
        List<WeatherData> weatherDataList = getWeatherData(cityName, countryCode);
        int count = weatherDataList.size();
        double totalTemperature = 0.0;
        double totalHumidity = 0.0;
        double totalPressure = 0.0;

        // Calculate the total temperature, humidity, and pressure
        for (WeatherData weatherData : weatherDataList) {
            totalTemperature += weatherData.getTemperature();
            totalHumidity += weatherData.getHumidity();
            totalPressure += weatherData.getPressure();
        }

        // Calculate the average temperature, humidity, and pressure
        double averageTemperature = totalTemperature / count;
        double averageHumidity = totalHumidity / count;
        double averagePressure = totalPressure / count;

        // Create a map to hold the results
        Map<String, Object> result = new HashMap<>();
        result.put("cityName", cityName);
        result.put("countryCode", countryCode);
        result.put("averageTemperature", averageTemperature);
        result.put("averageHumidity", averageHumidity);
        result.put("averagePressure", averagePressure);

        return result;
    }
}
