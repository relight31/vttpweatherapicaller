package com.example.WeatherAPICaller.services;

import java.util.Optional;

import com.example.WeatherAPICaller.model.CityWeather;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather";

    public Optional<CityWeather> getWeather(String cityName) {
        // create JSON string from API call
        String url = UriComponentsBuilder.fromUriString(WEATHER_URL)
                .queryParam("q", cityName)
                .queryParam("appid", "1f46f4727219553427d3d8d1479cad07")
                .toUriString();
        RestTemplate template = new RestTemplate();
        try {
            ResponseEntity<String> resp = template.getForEntity(url, String.class);
            CityWeather city = CityWeather.create(resp.getBody());
            return Optional.of(city);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
