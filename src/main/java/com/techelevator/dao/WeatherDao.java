package com.techelevator.dao;

import com.techelevator.model.LatLon;
import com.techelevator.model.User;
import com.techelevator.model.Weather;

public interface WeatherDao {

    Weather createWeather(Weather weather, User user, LatLon latLon);

    Weather getWeatherByUser(User user);
}
