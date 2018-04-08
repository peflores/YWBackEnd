package com.weather.redbee.weather.entity;

public class QueryWeather {

    private final static String URL = "https://query.yahooapis.com/v1/public/yql?q=";

    private String wo;

    @Override
    public String toString() {

        return URL;

    }
}
