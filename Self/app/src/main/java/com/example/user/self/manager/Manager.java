package com.example.user.self.manager;

import android.content.Context;

import com.example.user.self.Data.WeatherData;

/**
 * Created by User on 24/09/2015.
 */
public class Manager {
    private static Manager ourInstance = new Manager();
    String mResponceText;

    public WeatherData getWeatherData() {
        return mWeatherData;
    }

    public void setWeatherData(WeatherData mWeatherData) {
        this.mWeatherData = mWeatherData;
    }

    WeatherData mWeatherData;
    public static Manager getInstance() {
        return ourInstance;
    }

    public String setResponseText(String responseText){
        mResponceText = responseText;
        return mResponceText;
    }
    public String getResponceText(){
        return mResponceText;
    }


}
