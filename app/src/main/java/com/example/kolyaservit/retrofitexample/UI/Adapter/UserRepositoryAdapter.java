package com.example.kolyaservit.retrofitexample.UI.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.kolyaservit.retrofitexample.R;
import com.example.kolyaservit.retrofitexample.Retrofit.GitHub.Repository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryAdapter extends ArrayAdapter {

    private LayoutInflater inflater;
    @LayoutRes private int resource;
    private List<Repository> repositories;

    public UserRepositoryAdapter(Context context, int resource, List<Repository> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
        this.resource = resource;
        repositories = objects;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            v = inflater.inflate(resource, parent, false);
        }
        Repository repository = repositories.get(position);
        TextView name = v.findViewById(R.id.name_repository);
        TextView urlClone = v.findViewById(R.id.url_clone_repository);
        name.setText(repository.getName());
        urlClone.setText(repository.getCloneUrl());
        return v;
    }
}
