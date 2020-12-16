package com.web.app.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.app.forecast.Forecast;
import com.web.app.model.Coordinates;

import java.io.IOException;

public class JsonMapper {

    private final InputStreamMapper inputStreamMapper;

    public JsonMapper(InputStreamMapper inputStreamMapper) {
        this.inputStreamMapper = inputStreamMapper;
    }

    public Forecast mapJsonToForecast(Coordinates coordinates) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree = mapper.readTree(inputStreamMapper.mapInputStreamToString(coordinates));

        JsonNode node = tree.at("");
        return mapper.treeToValue(node, Forecast.class);
    }
}
