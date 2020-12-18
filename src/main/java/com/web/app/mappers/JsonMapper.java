package com.web.app.mappers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.app.model.forecast.Forecast;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsonMapper {

    private final InputStreamMapper inputStreamMapper;

    @Autowired
    public JsonMapper(InputStreamMapper inputStreamMapper) {
        this.inputStreamMapper = inputStreamMapper;
    }

    @SneakyThrows
    public Forecast mapJsonToForecast() {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree = mapper.readTree(inputStreamMapper.mapInputStreamToString());

        JsonNode node = tree.at("");
        return mapper.treeToValue(node, Forecast.class);
    }
}
