package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class weatherService {

    @Value("{weather.api.key}")
    private static  String apiKey;

    private static final String API="https://api.weatherstack.com/current?access_key=API_key&query=CITY";

     @Autowired
    private RestTemplate restTemplate;


     public WeatherResponse getWeather(String city){
         String finalAPI=API.replace("CITY",city).replace("API_KEY",apiKey);
         restTemplate.exchange(finalAPI, HttpMethod.POST, null,WeatherResponse.class);
         response.getStatusCode();
         WeatherResponse body=response.getBody();
         return body;
     }
}
