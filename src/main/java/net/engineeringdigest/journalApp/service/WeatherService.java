package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.WeatherResponse;
import net.engineeringdigest.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private static  String apiKey;



     @Autowired
    private RestTemplate restTemplate;

     @Autowired
     private AppCache appCache;


     public WeatherResponse getWeather(String city){
         String finalAPI=appCache.get(AppCache.keys.WEATHER_API.toString()).replace("CITY",city).replace("<apiKey>",apiKey);
         restTemplate.exchange(finalAPI, HttpMethod.POST, null,WeatherResponse.class);
         response.getStatusCode();
         WeatherResponse body=response.getBody();
         return body;
     }
}
