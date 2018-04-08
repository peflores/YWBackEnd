package com.weather.redbee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@Getter
@Setter
public class City  {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JsonProperty
    private String cityId;
    @JsonProperty
    private String date;
    @JsonProperty
    private String description;
    @JsonProperty
    private String idUser;
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

    private String timeLastQuery;
}
