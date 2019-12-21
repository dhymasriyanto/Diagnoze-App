package com.example.diagnoze.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.diagnoze.HalamanAwal;
import com.example.diagnoze.Macam2Penyakit;
import com.example.diagnoze.PertanyaanActivity;
import com.example.diagnoze.R;
import com.example.diagnoze.ThemeUtils;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        final Button DiagnosaPenyakit = root.findViewById(R.id.btn_diagnosa_penyakit);
        final Button RSTerdekat = root.findViewById(R.id.btn_rs_terdekat);
        final Button MacamPenyakit = root.findViewById(R.id.btn_macam_penyakit);

        DiagnosaPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),PertanyaanActivity.class);
                startActivity(i);
            }
        });

        MacamPenyakit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                penyakit();
            }
        });

        RSTerdekat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rs = null;
                String link = "https://www.google.co.id/maps/search/rumah+sakit/";
                rs = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(rs);

            }
        });
        return root;



    }

    public void penyakit() {
        Intent aha = new Intent(getActivity(), Macam2Penyakit.class);
        startActivity(aha);
    }
}