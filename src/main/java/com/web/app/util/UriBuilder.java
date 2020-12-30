package com.web.app.util;

import com.web.app.model.Coordinates;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public final class UriBuilder {

    private UriBuilder() {
        throw new AssertionError(this.getClass().getSimpleName() +
                " is an util class - can't be instantiated");
    }

    public static URI buildUri(Coordinates coordinates,
                               String baseUrl,
                               String authenticationToken) throws URISyntaxException {
        String uriAsAString = new StringBuilder(baseUrl)
                .append("/onecall")
                .append("?lat=").append(coordinates.getLatitude())
                .append("&lon=").append(coordinates.getLongitude())
                .append("&units=").append("metric")
                .append("&exclude=current,hourly,minutely")
                .append("&appid=").append(authenticationToken)
                .toString();

        return new URI(uriAsAString);
    }
}
