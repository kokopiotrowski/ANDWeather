package com.example.andweatherapp;

import androidx.lifecycle.ViewModelProvider;

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

import com.example.andweatherapp.ViewModels.MainWeatherViewModel;

public class MainWeather extends Fragment {

    private MainWeatherViewModel mViewModel;
    private Button checkWeatherButton;
    private EditText cityEditTextField;

    private TextView cityTextView;
    private TextView titleTextView;
    private TextView descriptionTextView;

    private ImageView weatherImageView;

    private String[] commentsBefore;
    private String[] commentsAfter;

    private Switch funnySwitch;

    public static MainWeather newInstance() {
        return new MainWeather();
    }

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

        weatherImageView = v.findViewById(R.id.weatherImageView);

        funnySwitch = v.findViewById(R.id.switchFunny);
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
                cityTextView.setText(weatherInfo.getName());
                weatherInfo.getMainConditions().setTemperatureToCelsius();
                titleTextView.setText(String.valueOf(weatherInfo.getMainConditions().getTemp()) + " *C");


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

                switch(weatherInfo.getListOfWeather().get(0).getIcon()) {
                    case "01d":
                    weatherImageView.setImageResource(R.drawable.icon01d);
                    break;
                    case "02d":
                        weatherImageView.setImageResource(R.drawable.icon02d);
                        break;
                    case "03d":
                        weatherImageView.setImageResource(R.drawable.icon03d);
                        break;
                    case "04d":
                        weatherImageView.setImageResource(R.drawable.icon04d);
                        break;
                    case "09d":
                        weatherImageView.setImageResource(R.drawable.icon09d);
                        break;
                    case "10d":
                        weatherImageView.setImageResource(R.drawable.icon10d);
                        break;
                    case "11d":
                        weatherImageView.setImageResource(R.drawable.icon11d);
                        break;
                    case "13d":
                        weatherImageView.setImageResource(R.drawable.icon13d);
                        break;
                    case "50d":
                        weatherImageView.setImageResource(R.drawable.icon50d);
                        break;
                    case "01n":
                        weatherImageView.setImageResource(R.drawable.icon01n);
                        break;
                    case "02n":
                        weatherImageView.setImageResource(R.drawable.icon02n);
                        break;
                    case "03n":
                        weatherImageView.setImageResource(R.drawable.icon03n);
                        break;
                    case "04n":
                        weatherImageView.setImageResource(R.drawable.icon04n);
                        break;
                    case "09n":
                        weatherImageView.setImageResource(R.drawable.icon09n);
                        break;
                    case "10n":
                        weatherImageView.setImageResource(R.drawable.icon10n);
                        break;
                    case "11n":
                        weatherImageView.setImageResource(R.drawable.icon11n);
                        break;
                    case "13n":
                        weatherImageView.setImageResource(R.drawable.icon13n);
                        break;
                    case "50n":
                        weatherImageView.setImageResource(R.drawable.icon50n);
                        break;
                }
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


}
