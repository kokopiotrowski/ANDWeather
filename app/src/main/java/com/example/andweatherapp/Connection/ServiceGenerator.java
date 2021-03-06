package com.example.andweatherapp.Connection;

import android.os.Build;

import com.example.andweatherapp.Connection.API.WeatherApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import androidx.annotation.RequiresApi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ServiceGenerator {


    private static OkHttpClient client = new OkHttpClient.Builder().build();
    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().
            baseUrl("https://api.openweathermap.org/data/2.5/").addConverterFactory(GsonConverterFactory.create()).client(client);
    private static Retrofit retrofit = retrofitBuilder.build();

    private static WeatherApi weatherApi = retrofit.create(WeatherApi.class);

    public static WeatherApi getWeatherApi() { return weatherApi;}


}
