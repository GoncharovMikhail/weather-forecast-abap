package com.web.app.reuest.builder;

import com.web.app.model.Coordinates;

import java.net.MalformedURLException;
import java.net.URL;

public class OpenWeatherMapRequestUrlBuilder {

    private final ApiConfiguration apiConfiguration;

    public OpenWeatherMapRequestUrlBuilder(ApiConfiguration apiConfiguration) {
        this.apiConfiguration = apiConfiguration;
    }

    public URL buildUrl(Coordinates coordinates) throws MalformedURLException {
        String url = new StringBuilder(apiConfiguration.buildBaseUrl())
                .append("/onecall")
                .append("?lat=").append(coordinates.getLatitude())
                .append("&lon=").append(coordinates.getLongitude())
                .append("&units=").append("metric")
                .append("&exclude=current,hourly,minutely")
                .append("&appid=").append(apiConfiguration.getAuthenticationToken())
                .toString();

        return new URL(url);
    }
}
