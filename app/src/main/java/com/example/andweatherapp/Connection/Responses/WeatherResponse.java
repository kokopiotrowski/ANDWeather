package com.example.andweatherapp.Connection.Responses;

import com.example.andweatherapp.Entities.Clouds;
import com.example.andweatherapp.Entities.Coordinates;
import com.example.andweatherapp.Entities.FullWeatherInfo;
import com.example.andweatherapp.Entities.MainConditions;
import com.example.andweatherapp.Entities.Sys;
import com.example.andweatherapp.Entities.Weather;
import com.example.andweatherapp.Entities.Wind;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    @SerializedName("coord")
    private Coordinates coordinates;
    @SerializedName("weather")
    private List<Weather> listOfWeather;
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private MainConditions mainConditions;
    @SerializedName("visibility")
    private double visibility;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("dt")
    private double dt;
    @SerializedName("sys")
    private Sys sys;
    @SerializedName("timezone")
    private double timezone;
    @SerializedName("id")
    private double id;
    @SerializedName("name")
    private String name;
    @SerializedName("cod")
    private int cod;

    public FullWeatherInfo getWeather(){
        return new FullWeatherInfo(coordinates,
                listOfWeather,
                base,
                mainConditions,
                visibility,
                wind,
                clouds,
                dt,
                sys,
                timezone,
                id,
                name,
                cod);
    }
}
