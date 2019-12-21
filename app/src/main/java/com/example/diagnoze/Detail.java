package com.example.diagnoze;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Detail extends AppCompatActivity {
    private static final String EXTRA_PENYAKIT = "nama";
    ImageView gambar_demam;
    TextView nama_demam, gejala_demam, pengobatan_demam, cara_pencegahan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.detail_macam_penyakit);

        fungsidetail();
    }

    private void fungsidetail() {
        gambar_demam = findViewById(R.id.gambardemam);
        nama_demam = findViewById(R.id.namademam);
        gejala_demam = findViewById(R.id.gejala);
        pengobatan_demam = findViewById(R.id.pengobatan);
        cara_pencegahan = findViewById(R.id.pencegahan);

        final Penyakit penyakit = getIntent().getParcelableExtra(EXTRA_PENYAKIT);
        assert penyakit != null;
        Glide.with(this).load(penyakit.getGambar())
                .apply(new RequestOptions())
                .into(gambar_demam);
        nama_demam.setText(penyakit.getNama_penyakit());
        gejala_demam.setText("Gejala Penyakit : \n"+penyakit.getGejala()+"\n");
        pengobatan_demam.setText("Pengobatan : \n"+penyakit.getPengobatan()+"\n");
        cara_pencegahan.setText("Cara Pencegahan : \n"+penyakit.getCara_mengatasi()+"\n");
    }
}
