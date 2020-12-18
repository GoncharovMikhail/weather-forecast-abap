package com.web.app;

import com.web.app.mappers.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Answer {

    private final JsonMapper jsonMapper;

    @Autowired
    public Answer(JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @PostConstruct
    public void getAnswer() {
        System.out.println(jsonMapper.mapJsonToForecast());
    }
}
