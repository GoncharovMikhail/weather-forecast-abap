package com.web.app.mappers;

import com.web.app.model.Coordinates;
import com.web.app.reuest.executor.OpenWeatherMapRequestExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamMapper {

    private final OpenWeatherMapRequestExecutor openWeatherMapRequestExecutor;

    public InputStreamMapper(OpenWeatherMapRequestExecutor openWeatherMapRequestExecutor) {
        this.openWeatherMapRequestExecutor = openWeatherMapRequestExecutor;
    }

    public String mapInputStreamToString(Coordinates coordinates) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        openWeatherMapRequestExecutor
                                .getInputStream(coordinates)
                )
        );

        StringBuilder result = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        reader.close();

        return result.toString();
    }
}
