package com.example.andweatherapp.Entities;

import java.util.List;

public class FullWeatherInfo {

    private Coordinates coordinates;
    private List<Weather> listOfWeather;
    private String base;
    private MainConditions mainConditions;
    private double visibility;
    private Wind wind;
    private Clouds clouds;
    private double dt;
    private Sys sys;
    private double timezone;
    private double id;
    private String name;
    private int cod;

    public FullWeatherInfo(Coordinates coordinates,
                           List<Weather> listOfWeather,
                           String base,
                           MainConditions mainConditions,
                           double visibility,
                           Wind wind,
                           Clouds clouds,
                           double dt,
                           Sys sys,
                           double timezone,
                           double id,
                           String name,
                           int cod) {
        this.coordinates = coordinates;
        this.listOfWeather = listOfWeather;
        this.base = base;
        this.mainConditions = mainConditions;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public List<Weather> getListOfWeather() {
        return listOfWeather;
    }

    public String getBase() {
        return base;
    }

    public MainConditions getMainConditions() {
        return mainConditions;
    }

    public double getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public double getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public double getTimezone() {
        return timezone;
    }

    public double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }
}
