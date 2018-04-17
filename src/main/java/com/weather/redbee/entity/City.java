package com.weather.redbee.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name="CITY")
@Data
@Getter
@Setter
@Table(name="CITY")
public class City {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "CITY_ID")
    private Long cityId;
    @Column(name = "DATE")
    private String date;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "LAT")
    private String lat;
    @Column(name = "LON")
    private String lon;
    @Column(name = "TEMP")
    private String temp;
    @Column(name = "TEXT")
    public String text;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "TIME_LAST_QUERY")
    private Timestamp timeLastQuery;

}
