package com.web.app.model.forecast;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@ToString

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dt",
        "sunrise",
        "sunset",
        "temp",
        "feels_like",
        "pressure",
        "humidity",
        "dew_point",
        "wind_speed",
        "wind_deg",
        "weather",
        "clouds",
        "pop",
        "rain",
        "uvi"
})
public class Daily {

    @JsonProperty("dt")
    public Integer dt;

    @JsonProperty("sunrise")
    public Integer sunrise;

    @JsonProperty("sunset")
    public Integer sunset;

    @ToString.Include
    @JsonProperty("temp")
    public Temp temp;

    @ToString.Include
    @JsonProperty("feels_like")
    public FeelsLike feelsLike;

    @JsonProperty("pressure")
    public Integer pressure;

    @JsonProperty("humidity")
    public Integer humidity;

    @JsonProperty("dew_point")
    public Double dewPoint;

    @JsonProperty("wind_speed")
    public Double windSpeed;

    @JsonProperty("wind_deg")
    public Integer windDeg;

    @ToString.Include
    @JsonProperty("weather")
    public List<Weather> weather = null;

    @JsonProperty("clouds")
    public Integer clouds;

    @JsonProperty("pop")
    public Double pop;

    @JsonProperty("rain")
    public Double rain;

    @JsonProperty("uvi")
    public Integer uvi;

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
