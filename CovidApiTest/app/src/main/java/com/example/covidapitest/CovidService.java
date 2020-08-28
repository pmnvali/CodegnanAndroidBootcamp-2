package com.example.covidapitest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidService {

    //https://api.covid19api.com/countries

    @GET("countries")
    Call<String> getCountriesData();
}
