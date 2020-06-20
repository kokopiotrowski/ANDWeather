package com.example.andweatherapp;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.andweatherapp.Helpers.WeatherViewHelper;
import com.example.andweatherapp.ViewModels.MainWeatherViewModel;

import java.util.HashSet;
import java.util.Set;

public class MainWeatherFragment extends Fragment {

    private MainWeatherViewModel mViewModel;
    private Button checkWeatherButton;
    private EditText cityEditTextField;

    private TextView cityTextView;
    private TextView titleTextView;
    private TextView descriptionTextView;

    private TextView humidityDataView;
    private TextView windDirectionView;
    private TextView windSpeedView;
    private TextView pressureDataView;
    private TextView cloudsPercentView;

    private ImageView weatherImageView;

    private String[] commentsBefore;
    private String[] commentsAfter;

    private SharedPreferences pref;
    private Set<String> searchHistorySet;

    private Switch funnySwitch;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.main_weather_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(MainWeatherViewModel.class);


        cityEditTextField = v.findViewById(R.id.enterCity);
        checkWeatherButton = v.findViewById(R.id.buttonWeather);

        cityTextView = v.findViewById(R.id.cityTextView);
        titleTextView = v.findViewById(R.id.weatherTitle);
        descriptionTextView = v.findViewById(R.id.weatherDescriptionTextView);

        humidityDataView = v.findViewById(R.id.humidityDataView);
        windSpeedView = v.findViewById(R.id.windSpeedView);
        windDirectionView = v.findViewById(R.id.windDirectionView);
        pressureDataView = v.findViewById(R.id.pressureDataView);
        cloudsPercentView = v.findViewById(R.id.cloudsPercentView);

        weatherImageView = v.findViewById(R.id.weatherImageView);

        funnySwitch = v.findViewById(R.id.switchFunny);

        pref = getActivity().getSharedPreferences("preferences", Context.MODE_PRIVATE);
        searchHistorySet = new HashSet<>();

        if(pref.getStringSet("searchHistory", null)!= null )
        {
            Set<String> set = pref.getStringSet("searchHistory", null);
            for(String historyInfo : set) {
                searchHistorySet.add(historyInfo);
            }
        }

        setObserversAndListeners();
        generateComments();

        return v;
    }

    private void setObserversAndListeners(){

        checkWeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.updateWeatherInfo(cityEditTextField.getText().toString());
            }
        });

        mViewModel.getWeatherInfo().observe(getViewLifecycleOwner(), weatherInfo ->
        {
            Log.i("object", weatherInfo.getMainConditions().toString());
            if(weatherInfo!=null)
            {
                weatherInfo.getMainConditions().setTemperatureToCelsius();

                cityTextView.setText(weatherInfo.getName());
                titleTextView.setText(String.valueOf(weatherInfo.getMainConditions().getTemp()) + "°C");
                if(funnySwitch.isChecked()) {
                    if(Math.random()>0.5){
                        descriptionTextView.setText(getRandomBeforeComment() + " " +weatherInfo.getListOfWeather().get(0).getMain());
                    }
                    else
                    {
                        descriptionTextView.setText(weatherInfo.getListOfWeather().get(0).getMain() + " " + getRandomAfterComment());
                    }
                }
                else {
                    descriptionTextView.setText(weatherInfo.getListOfWeather().get(0).getMain());
                }

                weatherImageView.setImageResource(WeatherViewHelper.getIconByCode(weatherInfo.getListOfWeather().get(0).getIcon()));

                searchHistorySet.add(weatherInfo.getListOfWeather().get(0).getIcon() + "|"
                        + weatherInfo.getName() + " "
                        + weatherInfo.getMainConditions().getTemp() + "°C");


                humidityDataView.setText(Double.toString(weatherInfo.getMainConditions().getHumidity()) + "%");
                pressureDataView.setText(Double.toString(weatherInfo.getMainConditions().getPressure()) + " hPa");
                windSpeedView.setText(Double.toString(weatherInfo.getWind().getSpeed()) + "m/s");
                windDirectionView.setText(WeatherViewHelper.getArrowForWindDeg(weatherInfo.getWind().getDeg()));
                cloudsPercentView.setText(Double.toString(weatherInfo.getClouds().getAll()) + "%");

                saveSearchHistory();

            }
        });

    }

    private void generateComments()
    {
        commentsBefore = getResources().getStringArray(R.array.before_comment);
        commentsAfter = getResources().getStringArray(R.array.after_comment);
    }

    private String getRandomBeforeComment(){
        int id = (int) Math.floor(Math.random() * commentsBefore.length);
        return commentsBefore[id];
    }

    private String getRandomAfterComment(){
        int id = (int) Math.floor(Math.random() * commentsAfter.length);
        return commentsAfter[id];
    }

    private void saveSearchHistory(){
        SharedPreferences.Editor editor = pref.edit();
        editor.putStringSet("searchHistory", searchHistorySet);
        editor.apply();
    }


}
