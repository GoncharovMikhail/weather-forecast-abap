package com.web.app;

import com.web.app.forecast.Forecast;
import com.web.app.model.Coordinates;
import com.web.app.reuest.manager.OpenWeatherMapManager;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class OpenWeatherMapApplicationRunner {

    private static final String AUTHENTICATION_TOKEN = "8cbbb03bd26f048fa7ebcf854aebf23c";
    private static final Coordinates COORDINATES = new Coordinates(0f, 0f);

    public static void main(String[] args) {
        Forecast forecast = OpenWeatherMapManager.getForecast(AUTHENTICATION_TOKEN, COORDINATES);

         List<Double> morningWeatherList = forecast.getDaily().stream()
                .map(daily -> daily.getTemp().getMorn())
                 .collect(Collectors.toList()).subList(0, 5);

        OptionalDouble average = morningWeatherList.stream()
                .mapToDouble(d -> d)
                .average();

        OptionalDouble max = morningWeatherList.stream()
                .mapToDouble(d -> d)
                .max();

        System.out.println("Average morn temperature: " + average.getAsDouble());
        System.out.println("Maximum morn temperature: " + max.getAsDouble());
    }
}
