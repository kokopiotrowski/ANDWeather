package com.example.andweatherapp.Connection.API;

import com.example.andweatherapp.Connection.Responses.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("weather")
    Call<WeatherResponse> getWeather(@Query("q") String city, @Query("appid") String appKey);
}
