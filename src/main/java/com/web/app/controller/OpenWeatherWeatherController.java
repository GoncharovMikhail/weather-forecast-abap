package com.web.app.controller;

import com.web.app.model.Coordinates;
import com.web.app.model.forecast.Forecast;
import com.web.app.service.MorningTemperatureService;
import com.web.app.service.OpenWeatherMapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.net.URISyntaxException;

@RestController
@Slf4j
public class OpenWeatherWeatherController {

    private final OpenWeatherMapService openWeatherMapRequestService;

    private final MorningTemperatureService morningTemperatureService;

    @Autowired
    public OpenWeatherWeatherController(OpenWeatherMapService openWeatherMapRequestService,
                                        MorningTemperatureService morningTemperatureService) {
        this.openWeatherMapRequestService = openWeatherMapRequestService;
        this.morningTemperatureService = morningTemperatureService;
    }

    @GetMapping("")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }

    @GetMapping(value = "/getweather")
    @ResponseBody
    public ModelAndView getWeather(@RequestParam Float latitude, @RequestParam Float longitude) throws URISyntaxException {
        Coordinates coordinates = new Coordinates(latitude, longitude);
        log.info("Starting to execute request to get forecast for the following coordinates: {}, {}",
                latitude,
                longitude);

        Forecast forecast = openWeatherMapRequestService.getForecast(coordinates);

        ModelAndView modelAndView = new ModelAndView("view");

        modelAndView.addObject("max",
                morningTemperatureService.getMaximalMorningTemperature(forecast));
        modelAndView.addObject("average",
                morningTemperatureService.getAverageMorningTemperature(forecast));

        return modelAndView;
    }
}
