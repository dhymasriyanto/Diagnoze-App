package com.example.diagnoze.ui.pengaturran;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.diagnoze.R;
import com.example.diagnoze.ThemeUtils;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pengaturan, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

//        final Switch sw = root.findViewById(R.id.switch1);
//
//        if (sw.isChecked()){
//            ThemeUtils.ubahTema(getActivity(),ThemeUtils.Black);
//        } else {
//            ThemeUtils.ubahTema(getActivity(),ThemeUtils.White);
//        }


        final Button dark = root.findViewById(R.id.btn_dark);
        final Button light = root.findViewById(R.id.btn_light);



        dark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemeUtils.ubahTema(getActivity(),ThemeUtils.Black);
//                dark.setVisibility(View.INVISIBLE);
//                light.setVisibility(View.VISIBLE);
            }
        });

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThemeUtils.ubahTema(getActivity(),ThemeUtils.White);
//                light.setVisibility(View.INVISIBLE);
//                dark.setVisibility(View.VISIBLE);
            }
        });





        return root;
    }
}