package com.example.user.self;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.user.self.interfaces.ResponseListener;
import com.example.user.self.manager.Manager;
import com.example.user.self.volley.VolleyWrapper;

public class MainActivity extends AppCompatActivity implements ResponseListener{

    TextView mText;
    VolleyWrapper volleyWrapper;
    Manager manager= Manager.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        volleyWrapper = new VolleyWrapper(getApplicationContext());

        volleyWrapper.request(this);


        mText =(TextView)findViewById(R.id.text);

    }


    @Override
    public void onResponseListener() {
        mText.setText(manager.getWeatherData().getWeather().get(0).getDescription());

    }
}
