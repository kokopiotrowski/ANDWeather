package com.example.andweatherapp.Entities;

import com.google.gson.annotations.SerializedName;

import java.math.BigInteger;

public class Sys {

    @SerializedName("type")
    private int type;
    @SerializedName("id")
    private BigInteger id;
    @SerializedName("message")
    private String message;

    public int getType() {
        return type;
    }

    public BigInteger getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
