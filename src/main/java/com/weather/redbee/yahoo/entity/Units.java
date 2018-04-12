package com.weather.redbee.yahoo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "item",
        "units"
})
public class Units {

    @JsonProperty("distance")
    private String distance;
    @JsonProperty("pressure")
    private String pressure;
    @JsonProperty("speed")
    private String speed;
    @JsonProperty("temperature")
    private String temperature;

    @JsonProperty("distance")
    public void setDistance(String distance) {
        this.distance = distance;
    }
    @JsonProperty("pressure")
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }
    @JsonProperty("speed")
    public void setSpeed(String speed) {
        this.speed = speed;
    }
    @JsonProperty("temperature")
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    @JsonProperty("distance")
    public String getDistance() {
        return distance;
    }
    @JsonProperty("pressure")
    public String getPressure() {
        return pressure;
    }
    @JsonProperty("speed")
    public String getSpeed() {
        return speed;
    }
    @JsonProperty("units")
    public String getTemperature() {
        return temperature;
    }
}
