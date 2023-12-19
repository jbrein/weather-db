package com.techelevator.dao;

import com.techelevator.model.LatLon;
import com.techelevator.model.User;
import com.techelevator.model.Weather;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcWeatherDao implements WeatherDao{

    private JdbcTemplate template;

    public JdbcWeatherDao(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public Weather createWeather(Weather weather, User user, LatLon latLon) {
        String sql = "";
        if(getWeatherByUser(user) == null) {
            sql = "INSERT INTO weather (user_id, zipcode, main, description, temperature) " +
                    "VALUES (?, ?, ?, ?, ?)";
            template.update(sql, user.getUserId(), latLon.getZip(), weather.getMain(), weather.getDescription(),
                    weather.getTemp());
        } else {
            sql = "UPDATE weather SET user_id = ? , zipcode = ?, main = ?, description = ?, temperature = ? " +
                    "WHERE user_id = ?";
            template.update(sql, user.getUserId(), latLon.getZip(), weather.getMain(), weather.getDescription(),
                    weather.getTemp(), user.getUserId());}

        return getWeatherByUser(user);
    }

    @Override
    public Weather getWeatherByUser(User user) {
        String sql = "SELECT main, description, temperature FROM weather " +
                "WHERE user_id= ?";
        SqlRowSet results = template.queryForRowSet(sql, user.getUserId());
        if (results.next()){
            return mapRowToWeather(results);
        }
        return null;
    }

    private Weather mapRowToWeather (SqlRowSet results){
        String main = results.getString("main");
        String description = results.getString("description");
        double temperature = results.getDouble("temperature");
        Weather weather = new Weather(main, description, temperature);
        return weather;
    }
}
