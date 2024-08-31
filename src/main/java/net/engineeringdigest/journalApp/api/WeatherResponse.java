package net.engineeringdigest.journalApp.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.catalina.connector.Request;

import javax.xml.stream.Location;
import java.util.List;

public class WeatherResponse {
    private Request request;
    private Location location;
    private Current current;

    public Class Current{

        @JsonProperty("observation_time")
        private String observationTime;


        private int temperature;

       @JsonProperty("weather_descriptions")
        private List<String> weather_description;


       private int feelslike;



    }



}
