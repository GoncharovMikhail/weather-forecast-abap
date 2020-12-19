package com.web.app.reuest.executor;

import com.web.app.model.forecast.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class OpenWeatherMapRequestExecutor {

    private final URI uri;

    private final RestTemplate restTemplate;

    @Autowired
    public OpenWeatherMapRequestExecutor(URI uri, RestTemplate restTemplate) {
        this.uri = uri;
        this.restTemplate = restTemplate;
    }

    public Forecast getForecast() {
        return restTemplate.getForObject(uri, Forecast.class);
    }
}