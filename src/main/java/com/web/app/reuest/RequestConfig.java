package com.web.app.reuest;

import com.web.app.model.Coordinates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("request.properties")
public class RequestConfig {

    @Value("${latitude}")
    private float latitude;

    @Value("${longitude}")
    private float longitude;

    @Bean
    public Coordinates coordinates() {
        return new Coordinates(latitude, longitude);
    }

    /* A request executor. */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
