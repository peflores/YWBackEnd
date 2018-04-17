package com.weather.redbee.dot;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {

    @JsonProperty
    private String cityId;
    @JsonProperty
    private String date;
    @JsonProperty
    private String description;
    @JsonProperty
    private String lat;
    @JsonProperty
    private String lon;
    @JsonProperty
    private String temp;
    @JsonProperty
    public String text;
    @JsonProperty
    private String title;
    @JsonProperty
    private String unit;

    private Timestamp timeLastQuery;

}
