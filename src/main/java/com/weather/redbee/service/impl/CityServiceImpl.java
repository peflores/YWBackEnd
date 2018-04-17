package com.weather.redbee.service.impl;

import com.weather.redbee.dao.CityDao;
import com.weather.redbee.dot.CityDTO;
import com.weather.redbee.entity.City;
import com.weather.redbee.service.CityService;
import com.weather.redbee.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Component
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private Utilities utilities;

    public List<CityDTO> findByTimeLastQuery(Timestamp lastQuery) {
        List<CityDTO> result = new ArrayList<CityDTO>();
        cityDao.findByTimeLastQuery(lastQuery).forEach(
                city -> {
                    CityDTO cityDTO = utilities.convertVOtoDTO(city);
                    result.add(cityDTO);
                }
        );
        return result;
    }

    public Optional<CityDTO> findByLatAndLong(String lat, String lon) {
        Optional<City> cityFind = cityDao.findByLatAndLong(lat, lon);
        return cityFind.flatMap(city -> Optional.of(utilities.convertVOtoDTO(city)));
    }

    @Override
    public List<CityDTO> findByBoardId(String idBoard) {
        List<CityDTO> result = new ArrayList<CityDTO>();
        cityDao.findByBoardId(Long.valueOf(idBoard)).forEach(
                city -> {
                    result.add(utilities.convertVOtoDTO(city));
                    city.setTimeLastQuery(utilities.getCurrentDateTime());
                    cityDao.save(city);
                }
        );
        return result;
    }

    @Override
    public CityDTO add(CityDTO city) {
        City cityVO = utilities.converDTOtoVO(city);
        City newCity = cityDao.save(cityVO);
        city.setCityId(String.valueOf(newCity.getCityId()));
        return city;
    }

    @Override
    public List<CityDTO> findAll() {
        List<CityDTO> result = new ArrayList<CityDTO>();
        cityDao.findAll().forEach(city -> {
            result.add(utilities.convertVOtoDTO(city));
        });
        return result;
    }

    public CityDTO update(CityDTO city) {
        return utilities.convertVOtoDTO(cityDao.save(utilities.converDTOtoVO(city)));
    }

    @Override
    public void delete(CityDTO cityDTO) {

    }

}
