package com.web.app.controller;

import com.web.app.service.impl.MorningTemperatureServiceImpl;
import com.web.app.util.UriBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URISyntaxException;

@ControllerAdvice
@Slf4j
public class ExceptionHandlingController {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        log.info("IN {}," +
                        " handling {}," +
                        " it has probably occurred in {}," +
                        " in 'getAverage(List<Double> morningTemperature)'" +
                        " or 'in getMax(List<Double> morningTemperature)'" +
                        " methods",
                this.getClass().getSimpleName(),
                illegalArgumentException,
                MorningTemperatureServiceImpl.class.getSimpleName());

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(URISyntaxException.class)
    public ResponseEntity<?> handleUrisSyntaxException(URISyntaxException uriSyntaxException) {
        log.info("IN {}," +
                        " handling {}," +
                        " it has probably occurred in {}," +
                        " or 'buildUri(Coordinates coordinates, String baseUrl, String authenticationToken)...'" +
                        " methods",
                this.getClass().getSimpleName(),
                uriSyntaxException,
                UriBuilder.class.getSimpleName());

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
