package com.weather.redbee.service;

import com.weather.redbee.dot.CityDTO;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface CityService extends GenericService<CityDTO> {

    List<CityDTO> findByTimeLastQuery(Timestamp lastQuery);

    Optional<CityDTO> findByLatAndLong(String lat, String lon);

    List<CityDTO> findByBoardId(String idBoard);

}
