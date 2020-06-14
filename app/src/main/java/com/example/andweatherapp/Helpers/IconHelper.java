package com.example.andweatherapp.Helpers;

import com.example.andweatherapp.R;

public class IconHelper {
    public static int getIconByCode(String code)
    {
        switch(code) {
            case "01d":
                return R.drawable.icon01d;
            case "02d":
                return R.drawable.icon02d;
            case "03d":
                return R.drawable.icon03d;
            case "04d":
                return R.drawable.icon04d;
            case "09d":
                return R.drawable.icon09d;
            case "10d":
                return R.drawable.icon10d;
            case "11d":
                return R.drawable.icon11d;
            case "13d":
                return R.drawable.icon13d;
            case "50d":
                return R.drawable.icon50d;
            case "01n":
                return R.drawable.icon01n;
            case "02n":
                return R.drawable.icon02n;
            case "03n":
                return R.drawable.icon03n;
            case "04n":
                return R.drawable.icon04n;
            case "09n":
                return R.drawable.icon09n;
            case "10n":
                return R.drawable.icon10n;
            case "11n":
                return R.drawable.icon11n;
            case "13n":
                return R.drawable.icon13n;
            case "50n":
                return R.drawable.icon50n;
        }
        return -1;
    }
}
