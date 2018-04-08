package com.weather.redbee.dao;

import com.weather.redbee.entity.Weather;
import org.springframework.data.repository.CrudRepository;

public interface WeatherDao extends CrudRepository<Weather, Long> {
}
