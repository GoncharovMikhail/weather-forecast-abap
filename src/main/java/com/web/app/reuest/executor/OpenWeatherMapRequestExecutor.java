package com.web.app.reuest.executor;

import com.web.app.model.Coordinates;
import com.web.app.reuest.builder.OpenWeatherMapRequestUrlBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class OpenWeatherMapRequestExecutor {

    private final OpenWeatherMapRequestUrlBuilder openWeatherMapRequestUrlBuilder;

    public OpenWeatherMapRequestExecutor(OpenWeatherMapRequestUrlBuilder openWeatherMapRequestUrlBuilder) {
        this.openWeatherMapRequestUrlBuilder = openWeatherMapRequestUrlBuilder;
    }

    public InputStream getInputStream(Coordinates coordinates) {
        InputStream resultStream = null;

        try {
            HttpURLConnection connection = (HttpURLConnection) openWeatherMapRequestUrlBuilder
                    .buildUrl(coordinates)
                    .openConnection();

            connection.setRequestMethod("GET");

            switch (connection.getResponseCode()) {
                case HttpURLConnection.HTTP_OK:
                    resultStream = connection.getInputStream();
                    break;
                case HttpURLConnection.HTTP_UNAUTHORIZED:
                    throw new IllegalAccessError("401 status - probably incorrect token");
                case HttpURLConnection.HTTP_NOT_FOUND:
                case HttpURLConnection.HTTP_BAD_REQUEST:
                    throw new NullPointerException("400 or 404 status");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return resultStream;
    }
}
