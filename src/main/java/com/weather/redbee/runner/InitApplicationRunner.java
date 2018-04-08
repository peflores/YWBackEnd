package com.weather.redbee.runner;

import com.weather.redbee.entity.City;
import com.weather.redbee.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitApplicationRunner implements ApplicationRunner {

    @Autowired
    private CityService cityService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        cityService.updateWeatherAll();
        System.out.println("##Hola Spring##");

    }
}
