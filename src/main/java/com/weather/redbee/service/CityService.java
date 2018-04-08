package com.weather.redbee.service;

import com.weather.redbee.dao.CityDao;
import com.weather.redbee.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class CityService {

    @Autowired
    private CityDao cityDao;

    public void updateWeatherAll() {

        cityDao.findAll().forEach(new Consumer<City>() {
            @Override
            public void accept(City city) {

            }
        });
    }

    public City addCity(City city) {

        return cityDao.save(city);

    }


}
