package com.example.user.self.volley;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.user.self.Data.WeatherData;
import com.example.user.self.interfaces.ResponseListener;
import com.example.user.self.manager.Manager;
import com.google.gson.Gson;

/**
 * Created by User on 24/09/2015.
 */
public class VolleyWrapper {
    RequestQueue requestQueue;
    Manager manager = Manager.getInstance();

    public VolleyWrapper(Context context){
        requestQueue = Volley.newRequestQueue(context);

    }

    public void request(final ResponseListener responseListener) {

        String url = "http://api.openweathermap.org/data/2.5/weather?q=Ashdod&units=metric";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Gson gson = new Gson();
                        WeatherData weatherData = gson.fromJson(response,WeatherData.class);

                        manager.setWeatherData(weatherData);
                        if(responseListener!=null){
                            responseListener.onResponseListener();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                manager.setResponseText("Error");
            }
        });
// Add the request to the RequestQueue.
        requestQueue.add(stringRequest);
    }



}
