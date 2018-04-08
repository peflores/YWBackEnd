package com.weather.redbee.rest;


import com.weather.redbee.entity.City;
import com.weather.redbee.service.CityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/serverSide")
public class ServiceRest {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/addCity", method = RequestMethod.POST)
    public City addCity(@RequestBody City city) {
        city.setDescription(getImgUrl(city.getDescription()));
        return cityService.addCity(city);
    }

    public String getImgUrl(String description) {
        return StringUtils.substringBefore(
                StringUtils.substringAfter(
                        description,"=\""), "\"/>");
    }

}
