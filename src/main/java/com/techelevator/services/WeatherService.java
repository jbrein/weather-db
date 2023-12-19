package com.techelevator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.LatLon;
import com.techelevator.model.Weather;
import org.springframework.web.client.RestTemplate;

public class WeatherService {
    private RestTemplate template = new RestTemplate();
    private final String API_URL = "http://api.openweathermap.org/";
    private final String API_KEY = "Your API Key here!";

    public LatLon getLatLong(String zip){
        String url = API_URL + "geo/1.0/zip?zip=" + zip + "&appid=" + API_KEY;
        return template.getForObject(url, LatLon.class);

    }

    public Weather getWeather(LatLon latLon){
        String url = API_URL + "data/2.5/weather?lat=" + latLon.getLat() +
                "&lon=" + latLon.getLon() + "&units=imperial&appid=" + API_KEY;
        String response = template.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(response);
            JsonNode weather = root.path("weather");
            String main = weather.path(0).path("main").asText();
            String description = weather.path(0).path("description").asText();
            double temp = root.path("main").path("temp").asDouble();
            return new Weather(main, description, temp);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
