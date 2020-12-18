package com.web.app.reuest;

import com.web.app.model.Coordinates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("request.properties")
@Slf4j
public class RequestConfig {

    @Value("${latitude}")
    private float latitude;

    @Value("${longitude}")
    private float longitude;

    @Bean
    public Coordinates coordinates() {
        return new Coordinates(latitude, longitude);
    }
}
