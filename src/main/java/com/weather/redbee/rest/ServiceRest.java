package com.weather.redbee.rest;

import com.weather.redbee.entity.City;
import com.weather.redbee.service.CityService;
import com.weather.redbee.utilities.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/serverSide")
public class ServiceRest {

    @Autowired
    private CityService cityService;

    @Autowired
    Utilities utilities;

    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    public City addCity(@RequestBody City city) {
        city.setDescription(utilities.getImgUrl(city.getDescription()));
        city.setTimeLastQuery(utilities.getCurrentDateTime());
        return cityService.addCity(city);
    }


    @RequestMapping(value = "/allCity", method = RequestMethod.GET)
    public Iterable<City> getAllCitys() {

        return cityService.findAll();

    }

}
