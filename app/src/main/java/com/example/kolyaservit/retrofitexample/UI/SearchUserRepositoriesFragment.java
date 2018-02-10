package com.example.kolyaservit.retrofitexample.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kolyaservit.retrofitexample.R;
import com.example.kolyaservit.retrofitexample.Retrofit.GitHub.GitHubAPI;
import com.example.kolyaservit.retrofitexample.Retrofit.GitHub.Repository;
import com.example.kolyaservit.retrofitexample.Rx.RxEditText;
import com.example.kolyaservit.retrofitexample.UI.Adapter.UserRepositoryAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchUserRepositoriesFragment extends Fragment {

    private EditText userSearchText;
    private ListView userRepositories;
    private TextView notFoundText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_repositories, container, false);
        userSearchText = v.findViewById(R.id.fragment_example_edit_text);
        userRepositories = v.findViewById(R.id.list_repositories);
        notFoundText = v.findViewById(R.id.not_found_repository);

        RxEditText.addTextWatcher(userSearchText)
                .debounce(750, TimeUnit.MILLISECONDS)
                .filter(s -> !s.isEmpty())
                .subscribe(s -> GitHubAPI.getApi().getUserRepos(s).enqueue(response));
        return v;
    }

    private Callback<List<Repository>> response = new Callback<List<Repository>>() {
        @Override
        public void onResponse(Call<List<Repository>> call, Response<List<Repository>> response) {
            try {
                if (response.body().size() > 0) {
                    notFoundText.setVisibility(View.GONE);
                    ArrayAdapter adapter = new UserRepositoryAdapter(getContext(),
                            R.layout.repository_item, response.body());
                    userRepositories.setAdapter(adapter);
                } else {
                    notFoundRepository();
                }
            } catch (Exception ignored) {
                notFoundRepository();
            }
        }

        @Override
        public void onFailure(Call<List<Repository>> call, Throwable t) {
            notFoundRepository();
        }
    };

    private void notFoundRepository() {
        notFoundText.setVisibility(View.VISIBLE);
        userRepositories.setAdapter(null);
    }
}
