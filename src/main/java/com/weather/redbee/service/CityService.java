package com.weather.redbee.service;

import com.weather.redbee.dao.CityDao;
import com.weather.redbee.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
public class CityService {

    @Autowired
    private CityDao cityDao;

    public City addCity(City city) {
        return cityDao.save(city);
    }

    public Iterable<City> findAll() {
        return cityDao.findAll();
    }

    public Iterable<City> findByTimeLastQuery(Timestamp lastQuery) {
        return cityDao.findByTimeLastQuery(lastQuery);
    }

    public City update(City city) { return cityDao.save(city); }

}
