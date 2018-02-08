package com.example.kolyaservit.retrofitexample.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kolyaservit.retrofitexample.R;
import com.example.kolyaservit.retrofitexample.Retrofit.Google.GoogleAPI;
import com.example.kolyaservit.retrofitexample.Retrofit.Google.data.GoogleAddress;
import com.example.kolyaservit.retrofitexample.UI.MainActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchAddressFragment extends Fragment {

    private EditText searchText;
    private Button searchButton;
    private TextView resultSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search_address, container, false);

        searchText = v.findViewById(R.id.search_edit_text);
        searchButton = v.findViewById(R.id.search_button);
        resultSearch = v.findViewById(R.id.result_text_view);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = searchText.getText().toString();
                if (!address.isEmpty()) {
                    GoogleAPI.getApi().searchAddress(address).enqueue(responseGoogle);
                }
            }
        });

        return v;
    }

    private Callback<GoogleAddress> responseGoogle = new Callback<GoogleAddress>() {
        @Override
        public void onResponse(Call<GoogleAddress> call, Response<GoogleAddress> response) {
            try {
                String address = response.body().getResults().get(0).getFormattedAddress();
                resultSearch.setText(address);
            } catch (Exception ignored) {
                resultSearch.setText("Ничего не найдено.");
            }
        }

        @Override
        public void onFailure(Call<GoogleAddress> call, Throwable t) {
            Log.e(MainActivity.TAG, "onFailure: ", t);
        }
    };
}
