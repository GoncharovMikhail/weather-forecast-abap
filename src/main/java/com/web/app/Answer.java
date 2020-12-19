package com.web.app;

import com.web.app.reuest.executor.OpenWeatherMapRequestExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//TODO ужас
@Component
public class Answer {

    private final OpenWeatherMapRequestExecutor openWeatherMapRequestExecutor;

    @Autowired
    public Answer(OpenWeatherMapRequestExecutor openWeatherMapRequestExecutor) {
        this.openWeatherMapRequestExecutor = openWeatherMapRequestExecutor;
    }

    /**
     * TODO а как нормально-то распечатать все это дело(для задания).Н у в плане гдк? Постконстракт - явно плохая идея.
     */
    @PostConstruct
    public void answer() {
        System.out.println(openWeatherMapRequestExecutor.getForecast());
    }
}
