package com.web.app.service.impl;

import com.web.app.model.forecast.Forecast;
import com.web.app.service.MorningTemperatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
@PropertySource("forecast.properties")
@Slf4j
public class MorningTemperatureServiceImpl implements MorningTemperatureService {

    @Value("${amount-of-days}")
    private Integer amountOfDays;

    private List<Double> listOfMorningTemperatures;

    private void initializeListOfMorningTemperatureIfNeeded(Forecast forecast) {
        if (listOfMorningTemperatures == null) {
            listOfMorningTemperatures = forecast
                    .getDaily().stream()
                    .map(daily -> daily.getTemp().getMorn())
                    .collect(Collectors.toList())
                    .subList(0, amountOfDays);
        }
    }

    public double getAverageMorningTemperature(Forecast forecast) {
        initializeListOfMorningTemperatureIfNeeded(forecast);

        OptionalDouble average = listOfMorningTemperatures
                .stream()
                .mapToDouble(d -> d)
                .average();
        if (average.isPresent()) {
            return average.getAsDouble();
        }
        //todo null может быть только если колекция пустая - т.е. коллекция(аргумент) не подходит
        log.info("Couldn't compute the average morning temperature");
        throw new IllegalArgumentException("Couldn't compute the average morning temperature");
    }

    public double getMaximalMorningTemperature(Forecast forecast) {
        initializeListOfMorningTemperatureIfNeeded(forecast);

        Double max = Collections.max(listOfMorningTemperatures);
        if (max != null) {
            return max;
        }
        //todo null может быть только если колекция пустая - т.е. коллекция(аргумент) не подходит
        log.info("Couldn't compute the maximal morning temperature");
        throw new IllegalArgumentException("Couldn't compute the maximal morning temperature");
    }
}
