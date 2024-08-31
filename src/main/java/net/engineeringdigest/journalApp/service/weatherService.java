package net.engineeringdigest.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

public class weatherService {

    @Component
    private static final String apiKey="2c774f65e4d764b3b9e1d359246edbc3";

    private static final String API="https://api.weatherstack.com/current?access_key=API_key&query=CITY";

     @Autowired
    private RestTemplate restTemplate;


     public String getWeather(String city){
         String finalAPI=API.replace("CITY",city).replace("API_KEY",apiKey);
         restTemplate.exchange(finalAPI, HttpMethod.GET, null,WeatherResponse.class)
     }
}
