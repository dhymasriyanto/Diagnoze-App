package com.example.diagnoze;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Macam2Penyakit extends AppCompatActivity {
    private static final String EXTRA_PENYAKIT = "nama";
    // INI CLASS UNTUK MACAM PENYAKIT
    private ArrayList<Penyakit> list = new ArrayList<>();

    RecyclerView rvDemam;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.macam_penyakit);

        rvDemam = findViewById(R.id.list_penyakit);
        rvDemam.setHasFixedSize(true);
        list.addAll(DataPenyakit.getListData());
        Grid();


    }

    private void Grid(){
        rvDemam.setLayoutManager(new GridLayoutManager(this,2));
        GridPenyakit grid = new GridPenyakit(list);
        rvDemam.setAdapter(grid);

        grid.setOnItemClickCallback(new GridPenyakit.OnItemClickCallback() {
            @Override
            public void onItemClicked(Penyakit data) {
                showIntent(data);
            }
        });

    }

    private void showIntent(Penyakit data) {
        Penyakit p = new Penyakit();
        Intent i = new Intent(this,Detail.class);
        p.setNama_penyakit(data.getNama_penyakit());
        p.setGambar(data.getGambar());
        p.setGejala(data.getGejala());
        p.setPengobatan(data.getPengobatan());
        p.setCara_mengatasi(data.getCara_mengatasi());

        i.putExtra(Macam2Penyakit.EXTRA_PENYAKIT, p);
        startActivity(i);

    }


}
