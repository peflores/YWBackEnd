package com.weather.redbee.runner;

import com.weather.redbee.entity.City;
import com.weather.redbee.service.CityService;
import com.weather.redbee.utilities.Utilities;
import com.weather.redbee.yahoo.YahooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InitApplicationRunner implements ApplicationRunner {

    @Autowired
    private CityService cityService;
    @Autowired
    private Utilities utilities;
    @Autowired
    private YahooService yahooService;

    public void run(ApplicationArguments args) throws Exception {
        cityService.findAll().forEach(city -> {
            City currentCity = yahooService.getDataFromYahooService(city);
            cityService.update(currentCity);
        });

    }
    @Scheduled(cron ="0 0 0 0-23 * *" )
    public void polling() {
        System.out.println("##polling##");
        cityService.findByTimeLastQuery(utilities.getBeforesHourDateTime())
                .forEach(city -> {
                    City currentCity = yahooService.getDataFromYahooService(city);
                    cityService.update(currentCity);
                }
                );
    }

}
