package com.example.kolyaservit.retrofitexample.UI;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.kolyaservit.retrofitexample.R;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Fragment searchAddressFragment = new SearchAddressFragment();
    private Fragment exampleFragment = new SearchUserRepositoriesFragment();
    private Fragment newExampleFragment = new NewExampleFragment();

    private TabLayout tabBottom;

    public static String TAG = "TAG_RETROFIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        addFragment(R.id.single_fragment_main, searchAddressFragment);

        tabBottom = findViewById(R.id.tab_bottom);
        tabBottom.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        addFragment(R.id.single_fragment_main, searchAddressFragment);
                        break;
                    case 1:
                        addFragment(R.id.single_fragment_main, exampleFragment);
                        break;
                    case 2:
                        addFragment(R.id.single_fragment_main, newExampleFragment);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    protected void addFragment(int id, Fragment fragment) {
        fragmentManager.beginTransaction().replace(id, fragment).commit();
    }
}
