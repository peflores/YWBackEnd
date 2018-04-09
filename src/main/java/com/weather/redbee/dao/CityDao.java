package com.weather.redbee.dao;

import com.weather.redbee.entity.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface CityDao extends CrudRepository<City, Long> {

    @Query("Select c from City c where c.timeLastQuery >= :lastQuery")
    Iterable<City> findByTimeLastQuery(@Param("lastQuery") Timestamp lastQuery);
}
