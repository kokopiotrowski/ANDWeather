package com.example.andweatherapp.Entities;

import com.google.gson.annotations.SerializedName;

public class MainConditions {

    @SerializedName("temp")
    private double temp;
    @SerializedName("feels_like")
    private double feels_like;
    @SerializedName("temp_min")
    private double temp_min;
    @SerializedName("temp_max")
    private double temp_max;
    @SerializedName("pressure")
    private double pressure;
    @SerializedName("humidity")
    private double humidity;

    private char temperatureType = 'k';


    public void setTemperatureToCelsius()
    {
        if(temperatureType=='k')
        {
            temp = Math.floor(temp-273.15);
            feels_like = Math.floor(feels_like-273.15);
            temp_min = Math.floor(temp_min-273.15);
            temp_max = Math.floor(temp_max-273.15);
            temperatureType = 'c';
        }
    }


    public double getTemp() {
        return temp;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
        return humidity;
    }

}
