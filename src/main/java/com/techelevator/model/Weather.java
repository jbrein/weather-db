package com.techelevator.model;

public class Weather {
    private String main;
    private String description;

    private double temp;

    public Weather(String main, String description, double temp) {
        this.main = main;
        this.description = description;
        this.temp = temp;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", temp=" + temp +
                '}';
    }
}
