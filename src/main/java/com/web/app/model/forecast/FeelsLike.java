package com.web.app.model.forecast;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@ToString

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "day",
        "night",
        "eve",
        "morn"
})
public class FeelsLike {

    @JsonProperty("day")
    public Double day;

    @JsonProperty("night")
    public Double night;

    @JsonProperty("eve")
    public Double eve;

    @JsonProperty("morn")
    public Double morn;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
