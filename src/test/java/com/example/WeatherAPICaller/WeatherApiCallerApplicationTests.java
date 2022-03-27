package com.example.WeatherAPICaller;

import com.example.WeatherAPICaller.services.WeatherService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
class WeatherApiCallerApplicationTests {

	@Autowired
	private WeatherService weatherService;

	@Test
	void contextLoads() {
	}

	@Test
	void shouldReturnTokyoWeather() {
		RequestBuilder req = MockMvcRequestBuilders.get("/weather")
				.queryParam("q", "tokyo")
				.accept(MediaType.APPLICATION_JSON_VALUE);
	}
}
