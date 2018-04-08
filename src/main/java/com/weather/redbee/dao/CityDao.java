package com.weather.redbee.dao;

import com.weather.redbee.entity.City;
import org.springframework.data.repository.CrudRepository;

import java.sql.Timestamp;
import java.util.List;

public interface CityDao extends CrudRepository<City, Long> {

    List<City> findByTimeLastQuery(Timestamp lastQuery);
}
