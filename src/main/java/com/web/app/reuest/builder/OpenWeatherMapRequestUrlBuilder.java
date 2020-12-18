package com.web.app.reuest.builder;

import com.web.app.model.Coordinates;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URL;

@Configuration
public class OpenWeatherMapRequestUrlBuilder {

    @Value("${base-url}")
    private String baseUrl;

    @Value("${authentication-token}")
    private String authenticationToken;

    @Bean
    @Autowired
    @SneakyThrows
    public URL buildUrl(Coordinates coordinates) {
        String url = new StringBuilder(baseUrl)
                .append("/onecall")
                .append("?lat=").append(coordinates.getLatitude())
                .append("&lon=").append(coordinates.getLongitude())
                .append("&units=").append("metric")
                .append("&exclude=current,hourly,minutely")
                .append("&appid=").append(authenticationToken)
                .toString();

        return new URL(url);
    }
}
