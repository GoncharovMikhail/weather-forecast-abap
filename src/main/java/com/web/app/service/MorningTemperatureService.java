package com.web.app.service;

import java.util.List;

public interface MorningTemperatureService {

    double getAverage(List<Double> morningTemperature);

    double getMaximum(List<Double> morningTemperature);
}
