package com.weather.redbee.dao;

import com.weather.redbee.entity.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface CityDao extends CrudRepository<City, Long> {

    @Query("SELECT c FROM CITY c WHERE c.timeLastQuery >= :lastQuery")
    Iterable<City> findByTimeLastQuery(@Param("lastQuery") Timestamp lastQuery);

    @Query("SELECT c FROM CITY c WHERE c.lat = :lat and c.lon = :lon")
    Optional<City> findByLatAndLong(@Param("lat") String lat, @Param("lon") String lon);

    @Query("SELECT c FROM CITY c INNER JOIN BOARD_CITY as bc on bc.cityId = c.cityId WHERE bc.boardId = :boardId")
    List<City> findByBoardId(@Param("boardId") Long boardId);
}
