package com.web.app.service;

import com.web.app.model.forecast.Forecast;

public interface MorningTemperatureService {

    double getAverageMorningTemperature(Forecast forecast);

    double getMaximalMorningTemperature(Forecast forecast);
}
