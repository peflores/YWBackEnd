package com.weather.redbee.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
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

    private Timestamp timeLastQuery;

    public String getCityId() {
        return cityId;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getTemp() {
        return temp;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }

    public Timestamp getTimeLastQuery() {
        return timeLastQuery;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTimeLastQuery(Timestamp timeLastQuery) {
        this.timeLastQuery = timeLastQuery;
    }
}
