package com.web.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Coordinates {

    @Getter
    private final float latitude;

    @Getter
    private final float longitude;
}
