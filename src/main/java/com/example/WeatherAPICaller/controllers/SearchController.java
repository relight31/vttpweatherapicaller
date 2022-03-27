package com.example.WeatherAPICaller.controllers;

import java.util.Optional;

import com.example.WeatherAPICaller.model.CityWeather;
import com.example.WeatherAPICaller.services.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

    @Autowired
    WeatherService weatherService;

    @GetMapping(path = "/search")
    public String getWeather(
            Model model,
            @RequestParam(name = "city") String cityName) {
        // unpack optional and handle
        Optional<CityWeather> opt = weatherService.getWeather(cityName);
        if (opt.isEmpty()) {
            return "notFound";
        }
        CityWeather city = opt.get();

        return "result";
    }
}
