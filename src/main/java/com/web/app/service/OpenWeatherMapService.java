package com.web.app.service;

import com.web.app.model.Coordinates;
import com.web.app.model.forecast.Forecast;

import java.net.URISyntaxException;

public interface OpenWeatherMapService {

    Forecast getForecast(Coordinates coordinates) throws URISyntaxException;
}
