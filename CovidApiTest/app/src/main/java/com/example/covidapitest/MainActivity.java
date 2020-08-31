package com.example.covidapitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
        retrofit = new Retrofit.Builder().baseUrl("https://api.covid19api.com/")
                .addConverterFactory(GsonConverterfactory.create(gson)).build();

        CovidService service = retrofit.create(CovidService.class);

        //Call<String> response = service.getCountriesData();

    }
}