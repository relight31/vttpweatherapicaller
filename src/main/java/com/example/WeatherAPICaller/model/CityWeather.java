package com.example.WeatherAPICaller.model;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class CityWeather {
    private String cityName;
    private String icon;
    private String description;
    private String temperature;
    private String feelsLike;

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getFeelsLike() {
        return this.feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public static CityWeather create(String jsonString) throws IOException {
        CityWeather city = new CityWeather();
        try (InputStream is = new ByteArrayInputStream(jsonString.getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonObject data = reader.readObject();

            city.setCityName(data.getString("name"));
            String desc1 = data.getJsonArray("weather")
                    .getJsonObject(0)
                    .getString("main");
            String desc2 = data.getJsonArray("weather")
                    .getJsonObject(0)
                    .getString("description");
            city.setDescription("%s : %s".formatted(desc1, desc2));
            city.setIcon(data.getJsonArray("weather")
                    .getJsonObject(0)
                    .getString("icon"));
            city.setFeelsLike(data.getJsonObject("main")
                    .getString("temp"));
            city.setTemperature(data.getJsonObject("main")
                    .getString("feels_like"));
            return city;
        }
    }
}
