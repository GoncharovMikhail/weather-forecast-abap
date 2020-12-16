package com.web.app.forecast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "lat",
        "lon",
        "timezone",
        "timezone_offset",
        "daily"
})
public class Forecast {

    @JsonProperty("lat")
    private Integer lat;

    @JsonProperty("lon")
    private Integer lon;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("timezone_offset")
    private Integer timezoneOffset;

    @JsonProperty("daily")
    private List<Daily> daily = null;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonProperty("lat")
    public Integer getLat() {
        return lat;
    }

    @JsonProperty("lat")
    public void setLat(Integer lat) {
        this.lat = lat;
    }

    @JsonProperty("lon")
    public Integer getLon() {
        return lon;
    }

    @JsonProperty("lon")
    public void setLon(Integer lon) {
        this.lon = lon;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("timezone_offset")
    public Integer getTimezoneOffset() {
        return timezoneOffset;
    }

    @JsonProperty("timezone_offset")
    public void setTimezoneOffset(Integer timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    @JsonProperty("daily")
    public List<Daily> getDaily() {
        return daily;
    }

    @JsonProperty("daily")
    public void setDaily(List<Daily> daily) {
        this.daily = daily;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
