package com.example.kolyaservit.retrofitexample.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.kolyaservit.retrofitexample.R;
import com.example.kolyaservit.retrofitexample.Retrofit.GitHub.Repository;
import com.example.kolyaservit.retrofitexample.Retrofit.Google.GoogleAPI;
import com.example.kolyaservit.retrofitexample.Retrofit.Google.data.GoogleAddress;
import com.example.kolyaservit.retrofitexample.Retrofit.Google.data.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    public static String TAG = "TAG_RETROFIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        addFragment(R.id.second_fragment, ExampleFragment.class);
        addFragment(R.id.first_fragment, NewExampleFragment.class);

        GoogleAPI.getApi().searchAddress("Минск").enqueue(responseGoogleApi);
        //GitHubAPI.getApi().getUserRepos("KolyaBLR").enqueue(responseGitHub);
    }

    protected void addFragment(int id, Class fragment) {
        try {
            Fragment exampleFragment = fragmentManager.findFragmentById(id);
            if (exampleFragment == null) {
                exampleFragment = (Fragment) fragment.newInstance();
                fragmentManager.beginTransaction()
                        .add(R.id.second_fragment, exampleFragment).commit();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Callback<GoogleAddress> responseGoogleApi = new Callback<GoogleAddress>() {
        @Override
        public void onResponse(Call<GoogleAddress> call, Response<GoogleAddress> response) {
            String value = response.body().getResults().get(0).getFormattedAddress();
            Log.d(TAG, "onResponse: " + response.body().getStatus());
            Log.d(TAG, "onResponse: " + value);
        }

        @Override
        public void onFailure(Call<GoogleAddress> call, Throwable t) {
            Log.e(TAG, "onFailure: ", t);
        }
    };

    private Callback<List<Repository>> responseGitHub = new Callback<List<Repository>>() {
        @Override
        public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
            Log.d(TAG, "onResponse: success");
        }

        @Override
        public void onFailure(Call<List<Repository>> call, Throwable t) {
            Log.e(TAG, "onFailure: error", t);
        }
    };
}
