package com.example.andweatherapp.Entities;

import com.google.gson.annotations.SerializedName;

public class Coordinates {
    @SerializedName("lon")
    private double lon;
    @SerializedName("lat")
    private double lat;

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
}
