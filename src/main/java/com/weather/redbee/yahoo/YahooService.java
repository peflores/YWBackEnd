package com.weather.redbee.yahoo;

import com.weather.redbee.entity.City;
import com.weather.redbee.utilities.Utilities;
import com.weather.redbee.yahoo.entity.YahooQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
@Component
public class YahooService {

    private String URL_API_YAHOO = "http://query.yahooapis.com/v1/public/yql?" +
            "format=json&q=select units, item from weather.forecast where u=\"c\" and  woeid in ";

    private String QUERY_API_YAHOO = "(select woeid from geo.places(1) where text=\"(";

    private StringBuilder query;

    @Autowired
    private Utilities utilities;

    public YahooService() {
        query = new StringBuilder();
    }
    public City getDataFromYahooService(City city) {

        query.append(URL_API_YAHOO).append(QUERY_API_YAHOO)
                .append(city.getLat()).append(",")
                .append(city.getLon()).append(")\")");

        RestTemplate restTemplate = new RestTemplate();
        try {
            YahooQuery responseCity = restTemplate.getForObject(query.toString(), YahooQuery.class);
            city.setDescription(utilities.getImgUrl(responseCity.getQuery().getResults().getChannel().getItem().getDescription()));
            city.setTemp(responseCity.getQuery().getResults().getChannel().getItem().getCondition().getTemp());
            city.setText(responseCity.getQuery().getResults().getChannel().getItem().getCondition().getText());
            city.setTemperature(responseCity.getQuery().getResults().getChannel().getUnits().getTemperature());
        }catch (HttpClientErrorException e){
            System.out.println("Query: " + query.toString());
            System.out.println(e);
        }
        query.delete(0,query.length());
        return city;
    }
}
