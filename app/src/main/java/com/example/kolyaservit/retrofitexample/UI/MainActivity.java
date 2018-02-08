package com.example.kolyaservit.retrofitexample.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kolyaservit.retrofitexample.R;
import com.example.kolyaservit.retrofitexample.Retrofit.GitHub.GitHubAPI;
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
        addFragment(R.id.fragment_1, SearchAddressFragment.class);
        addFragment(R.id.fragment_2, ExampleFragment.class);
        addFragment(R.id.fragment_3, NewExampleFragment.class);
    }

    protected void addFragment(int id, Class fragment) {
        try {
            Fragment exampleFragment = fragmentManager.findFragmentById(id);
            if (exampleFragment == null) {
                exampleFragment = (Fragment) fragment.newInstance();
                fragmentManager.beginTransaction()
                        .add(id, exampleFragment).commit();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
