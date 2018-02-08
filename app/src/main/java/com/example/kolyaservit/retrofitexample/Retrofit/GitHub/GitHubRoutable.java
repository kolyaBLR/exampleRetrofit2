package com.example.kolyaservit.retrofitexample.Retrofit.GitHub;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubRoutable {
    @GET("/users/{user}/repos")
    Call<List<Repository>> getUserRepos(@Path("user") String user);
}
