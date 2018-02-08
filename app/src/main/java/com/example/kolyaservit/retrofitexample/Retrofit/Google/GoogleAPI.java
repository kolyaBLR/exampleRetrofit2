package com.example.kolyaservit.retrofitexample.Retrofit.Google;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GoogleAPI {

    private static GoogleRoutable googleRoutableApi;

    private GoogleAPI() {
        googleRoutableApi = new Retrofit.Builder()
                .baseUrl("http://maps.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(GoogleRoutable.class);
    }

    public static GoogleRoutable getApi() {
        if (googleRoutableApi == null) {
            new GoogleAPI();
        }
        return googleRoutableApi;
    }
}
