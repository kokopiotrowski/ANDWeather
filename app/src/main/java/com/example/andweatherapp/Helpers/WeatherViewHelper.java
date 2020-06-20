package com.example.andweatherapp.Helpers;

import com.example.andweatherapp.R;

public class WeatherViewHelper {
    public static String getArrowForWindDeg(double deg){
        if(deg<22.5){
            return "⇑"; //up N
        }
        else if(deg<67.5)
        {
            return "⇗"; // up-right NE
        }
        else if(deg<112.5){
            return "⇒"; // right E
        }
        else if(deg<157.5){
            return "⇘"; // down-right SE
        }
        else if(deg<202.5){
            return "⇓"; // down S
        }
        else if(deg<247.5){
            return "⇙"; // down-left SW
        }
        else if(deg<292.5){
            return "⇐"; // left W
        }
        else if(deg<337.5){
            return "⇖"; // up-left NW
        }
        else if(deg<=360){
            return "⇑"; //up N
        }
    return "-";

    }



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
