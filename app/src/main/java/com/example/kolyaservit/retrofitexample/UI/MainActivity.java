package com.example.kolyaservit.retrofitexample.UI;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.kolyaservit.retrofitexample.R;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Fragment activeFragment;

    private TabLayout tabBottom;

    public static String TAG = "TAG_RETROFIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        updateFragment(R.id.single_fragment_main, SearchAddressFragment.class);

        tabBottom = findViewById(R.id.tab_bottom);
        tabBottom.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        updateFragment(R.id.single_fragment_main, SearchAddressFragment.class);
                        break;
                    case 1:
                        updateFragment(R.id.single_fragment_main, ExampleFragment.class);
                        break;
                    case 2:
                        updateFragment(R.id.single_fragment_main, NewExampleFragment.class);
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

    protected void updateFragment(int id, Class fragment) {
        if (activeFragment != null) {
            removeFragment(activeFragment);
        }
        addFragment(id, fragment);
    }

    protected void removeFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .remove(fragment).commit();
    }

    protected void addFragment(int id, Class fragment) {
        try {
            Fragment exampleFragment = (Fragment) fragment.newInstance();
            fragmentManager.beginTransaction().add(id, exampleFragment).commit();
            activeFragment = exampleFragment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
