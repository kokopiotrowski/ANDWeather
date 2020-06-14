package com.example.andweatherapp.ViewModels;

import android.app.Application;

import com.example.andweatherapp.Entities.FullWeatherInfo;
import com.example.andweatherapp.Repository.WeatherRepository;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class MainWeatherViewModel extends AndroidViewModel {

    private WeatherRepository weatherRepository;

    public MainWeatherViewModel(@NonNull Application application) {
        super(application);
        weatherRepository = WeatherRepository.getInstance();
    }

    public LiveData<FullWeatherInfo> getWeatherInfo() {
        return weatherRepository.getWeatherInfo();
    }

    public void updateWeatherInfo(String city) {
        weatherRepository.updateWeatherInfo(city);
    }
}
