package com.example.andweatherapp.Entities;

import com.google.gson.annotations.SerializedName;

public class Clouds {
    @SerializedName("all")
    private int all;

    public int getAll() {
        return all;
    }
}
