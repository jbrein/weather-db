package com.techelevator.model;

public class LatLon {
    private int zip;
    private double lat;
    private double lon;


    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "LatLon{" +
                "zip=" + zip +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
