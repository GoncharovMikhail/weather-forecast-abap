package com.web.app.service.impl;

import com.web.app.model.forecast.Forecast;
import com.web.app.service.OpenWeatherMapService;
import com.web.app.util.UriBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.web.app.model.Coordinates;

import java.net.URI;
import java.net.URISyntaxException;

@Service
@Slf4j
public class OpenWeatherMapServiceImpl implements OpenWeatherMapService {

    @Value("${base-url}")
    private String baseUrl;

    @Value("${authentication-token}")
    private String authenticationToken;

    private final RestTemplate restTemplate;

    @Autowired
    public OpenWeatherMapServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Forecast getForecast(Coordinates coordinates) throws URISyntaxException {
        URI uri = UriBuilder.buildUri(coordinates, baseUrl, authenticationToken);
        return restTemplate.getForObject(uri, Forecast.class);
    }
}