package com.web.app.reuest.executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Configuration
public class OpenWeatherMapRequestExecutor {

    private final URL url;

    @Autowired
    public OpenWeatherMapRequestExecutor(URL url) {
        this.url = url;
    }

    @Bean
    public InputStream getInputStream() {
        InputStream resultStream = null;

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            switch (connection.getResponseCode()) {
                case HttpURLConnection.HTTP_OK:
                    resultStream = connection.getInputStream();
                    break;
                case HttpURLConnection.HTTP_UNAUTHORIZED:
                    throw new IllegalAccessError("401 status - probably incorrect token");
                case HttpURLConnection.HTTP_NOT_FOUND:
                case HttpURLConnection.HTTP_BAD_REQUEST:
                    throw new NullPointerException("400 or 404 status - probably incorrect URL");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return resultStream;
    }
}
