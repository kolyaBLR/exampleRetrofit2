package com.example.kolyaservit.retrofitexample.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.kolyaservit.retrofitexample.R;

public class NewExampleFragment extends Fragment {

    private TextView mSizeText;
    private SeekBar mSizeBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_new_example, container, false);
       mSizeText = v.findViewById(R.id.new_example_fragment_text_view);
       mSizeBar = v.findViewById(R.id.new_example_fragment_seek_bar);
       mSizeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               mSizeText.setText(Integer.toString(mSizeBar.getProgress()));
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

           }
       });
       return v;
    }
}
