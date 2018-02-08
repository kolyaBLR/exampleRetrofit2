package com.example.kolyaservit.retrofitexample.Retrofit.GitHub;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubAPI {

    private static GitHubRoutable gitHubApi;

    private GitHubAPI() {
        gitHubApi = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(GitHubRoutable.class);
    }

    public static GitHubRoutable getApi() {
        if (gitHubApi == null)
             new GitHubAPI();
        return gitHubApi;
    }
}
