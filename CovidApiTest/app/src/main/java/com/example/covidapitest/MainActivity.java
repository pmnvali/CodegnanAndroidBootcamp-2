package com.example.covidapitest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
        retrofit = new Retrofit.Builder().baseUrl("https://api.covid19api.com/")
                .addConverterFactory(ScalarsConverterFactory.create()).build();

        CovidService service = retrofit.create(CovidService.class);

        Call<String> response = service.getCountriesData();
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                /*Toast.makeText(MainActivity.this,
                        ""+response.body(), Toast.LENGTH_SHORT).show();*/
                try {
                    JSONArray roortJsonArray = new JSONArray(response.body());
                    for(int i = 0;i<roortJsonArray.length();i++){
                        JSONObject jsonObject = roortJsonArray.getJSONObject(i);
                        String Countryname = jsonObject.getString("Country");
                        String countrycode = jsonObject.getString("ISO2");
                        Toast.makeText(MainActivity.this,
                                ""+countrycode+"\n"+Countryname, Toast.LENGTH_SHORT).show();
                        Log.i("DATA",Countryname+" "+countrycode);

                    }
                    Log.i("DATA",""+roortJsonArray.length());
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });





    }
}