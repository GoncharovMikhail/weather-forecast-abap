package com.web.app.reuest.manager;

import com.web.app.forecast.Forecast;
import com.web.app.mappers.InputStreamMapper;
import com.web.app.mappers.JsonMapper;
import com.web.app.model.Coordinates;
import com.web.app.reuest.builder.ApiConfiguration;
import com.web.app.reuest.builder.OpenWeatherMapRequestUrlBuilder;
import com.web.app.reuest.executor.OpenWeatherMapRequestExecutor;

import java.io.IOException;

public class OpenWeatherMapManager {

    public static Forecast getForecast(String authenticationToken, Coordinates coordinates) {
        Forecast forecast = null;
        try {
            forecast = new JsonMapper(
                    new InputStreamMapper(
                            new OpenWeatherMapRequestExecutor(
                                    new OpenWeatherMapRequestUrlBuilder(
                                            new ApiConfiguration(authenticationToken)
                                    )
                            )
                    )
            ).mapJsonToForecast(coordinates);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forecast;
    }
}
