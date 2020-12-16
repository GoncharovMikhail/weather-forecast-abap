package com.web.app.reuest.builder;

import lombok.Getter;

public class ApiConfiguration {

    public final String OPEN_WEATHER_MAP_API_URL = "https://api.openweathermap.org";
    public String prefix = "data";
    public String apiVersion = "2.5";

    @Getter
    private final String authenticationToken;

    public ApiConfiguration(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }

    public ApiConfiguration(String prefix, String authenticationToken) {
        this.prefix = prefix;
        this.authenticationToken = authenticationToken;
    }

    public ApiConfiguration(String prefix, String apiVersion, String authenticationToken) {
        this.prefix = prefix;
        this.apiVersion = apiVersion;
        this.authenticationToken = authenticationToken;
    }

    public String buildBaseUrl() {
        return OPEN_WEATHER_MAP_API_URL +
                "/" +
                prefix +
                "/" +
                apiVersion;
    }
}
