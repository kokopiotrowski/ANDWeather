package com.example.andweatherapp.Repository;

import android.util.Log;

import com.example.andweatherapp.Connection.API.WeatherApi;
import com.example.andweatherapp.Connection.Responses.WeatherResponse;
import com.example.andweatherapp.Connection.ServiceGenerator;
import com.example.andweatherapp.Entities.FullWeatherInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherRepository {
    private final String APP_KEY = "77464aa91e0146f8d73159ecdd141ea4";
    private static WeatherRepository instance;
    private MutableLiveData<FullWeatherInfo> weatherInfo;

    private WeatherRepository()
    {
        weatherInfo = new MutableLiveData<>();
    }

    public static synchronized WeatherRepository getInstance(){
        if(instance == null) {
            synchronized (WeatherRepository.class){
                if(instance == null){
                    instance = new WeatherRepository();
                }
            }
        }
        return instance;
    }

    public void updateWeatherInfo(String city)
    {
        WeatherApi weatherApi = ServiceGenerator.getWeatherApi();
        Call<WeatherResponse> call = weatherApi.getWeather(city, APP_KEY);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if(response.code() == 200)
                {
                    weatherInfo.setValue(response.body().getWeather());
                    Log.i("Weather", "Weather retrieved properly: " + weatherInfo.getValue().toString());
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.i("Weather", t.getMessage());
            }
        });
    }

    public LiveData<FullWeatherInfo> getWeatherInfo(){
        return weatherInfo;
    }

}
