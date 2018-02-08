package com.example.kolyaservit.retrofitexample.Retrofit.Google;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GoogleRoutable {
    @GET("/maps/api/geocode/json")
    Call<GoogleAddress> searchAddress(@Query("address") String address, @Query("sensor") boolean sensor);
}
