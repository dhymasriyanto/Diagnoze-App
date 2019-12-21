package com.example.diagnoze;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.diagnoze.Rest.BaseApiService;
import com.example.diagnoze.Rest.UtilsApi;
import com.example.diagnoze.model.Pertanyaan;

import java.util.Arrays;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PertanyaanActivity extends AppCompatActivity {
    TextView pertanyaan, judul;
    Button btnTidak , btnYa;

    private int ID_GEJALA = 1;

    private int ID_PENYAKIT[] = new int[41];


    private AppBarConfiguration mAppBarConfiguration;
    private BaseApiService mApiService;
    private SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan);
        judul = findViewById(R.id.tv_judul);
        pertanyaan = findViewById(R.id.tv_pertanyaan);

        btnYa = findViewById(R.id.btn_ya);
        btnTidak = findViewById(R.id.btn_tidak);

        sharedPrefManager = new SharedPrefManager(this);
        sharedPrefManager.saveSPInt(SharedPrefManager.SP_ID_GEJALA, ID_GEJALA);

        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
        getPertanyaan();

        btnYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefManager.saveSPInt(SharedPrefManager.SP_ID_GEJALA, ID_GEJALA);
                mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

                ID_PENYAKIT[ID_GEJALA-2]=ID_GEJALA-1;
                getPertanyaan();

                if (ID_GEJALA == 41){



                Intent i = new Intent(PertanyaanActivity.this, ResultsActivity.class);

                startActivity(i);
                finish();
                submitNilai();
                }

            }
        });
        btnTidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefManager.saveSPInt(SharedPrefManager.SP_ID_GEJALA, ID_GEJALA);
                mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper

                ID_PENYAKIT[ID_GEJALA-2]=99;
                getPertanyaan();
                if (ID_GEJALA == 41){

                    Intent i = new Intent(PertanyaanActivity.this, ResultsActivity.class);

                    startActivity(i);
                    finish();
                    submitNilai();
                }
//                Intent i = new Intent(PertanyaanActivity.this, PertanyaanActivity.class);
//
//                startActivity(i);
            }
        });
    }

    private void getPertanyaan() {
        sharedPrefManager.saveSPInt(SharedPrefManager.SP_ID_GEJALA, ID_GEJALA);
        mApiService.getPertanyaan(sharedPrefManager.getSpIdGejala()).enqueue(new Callback<Pertanyaan>() {
            @Override
            public void onResponse(Call<Pertanyaan> call, final Response<Pertanyaan> response) {
                if (response.body() != null) {
                    judul.setText("Pertanyaan " + ID_GEJALA++ + Arrays.toString(ID_PENYAKIT));
                    pertanyaan.setText(" Apakah " + response.body().getData().get(0).getNamaGejala() + "?");
                } else {
                    Toast.makeText(PertanyaanActivity.this, "Tidak ada respon server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Pertanyaan> call, Throwable t) {
                Toast.makeText(PertanyaanActivity.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                Log.d("RETROFIT", t.getMessage());
            }
        });
    }


    private void submitNilai(){
        mApiService.penyakit(Arrays.toString(ID_PENYAKIT)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()){

                    Log.d("Retrofit", "Success");
                    Toast.makeText(PertanyaanActivity.this, "Input Nilai Berhasil", Toast.LENGTH_LONG).show();
                }else{
                    if (response.code() == 404){

                        Toast.makeText(PertanyaanActivity.this, "Not Found", Toast.LENGTH_SHORT).show();
                    }else{

                        Toast.makeText(PertanyaanActivity.this, "Terjadi Kesalahan", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.d("Retrofit", "Fail");
                Log.d("Retrofit", "Failure  :" + t.toString());
                Toast.makeText(PertanyaanActivity.this, "Gagal terhubung ke server", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
