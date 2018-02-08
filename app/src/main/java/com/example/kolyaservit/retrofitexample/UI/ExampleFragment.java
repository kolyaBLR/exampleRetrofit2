package com.example.kolyaservit.retrofitexample.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kolyaservit.retrofitexample.R;

public class ExampleFragment extends Fragment {

    private TextView mText;
    private EditText mEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_example, container, false);
        mText = v.findViewById(R.id.fragment_example_text);
        mText.setText(R.string.fragment_title);
        mEditText = v.findViewById(R.id.fragment_example_edit_text);
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mText.setText(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        
        return v;
    }
}
