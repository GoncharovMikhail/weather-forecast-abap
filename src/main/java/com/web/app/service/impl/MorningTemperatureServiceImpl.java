package com.web.app.service.impl;

import com.web.app.service.MorningTemperatureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;

@Service
@Slf4j
public class MorningTemperatureServiceImpl implements MorningTemperatureService {

    public double getAverage(List<Double> morningTemperature) {
        OptionalDouble average = morningTemperature
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

    public double getMaximum(List<Double> morningTemperature) {
        Double max = Collections.max(morningTemperature);
        if (max != null) {
            return max;
        }
        //todo null может быть только если колекция пустая - т.е. коллекция(аргумент) не подходит
        log.info("Couldn't compute the maximal morning temperature");
        throw new IllegalArgumentException("Couldn't compute the maximal morning temperature");
    }
}
