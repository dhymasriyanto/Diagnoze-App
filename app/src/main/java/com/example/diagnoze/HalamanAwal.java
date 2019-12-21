package com.example.diagnoze;

import android.content.Intent;
import android.os.Bundle;

import com.example.diagnoze.Rest.BaseApiService;
import com.example.diagnoze.Rest.UtilsApi;
import com.example.diagnoze.model.Pertanyaan;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.button.MaterialButton;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HalamanAwal extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private BaseApiService mApiService;
    private SharedPrefManager sharedPrefManager;

//    private int ID_GEJALA = 1;

//    Button DiagnosaPenyakit, RSTerdekat, MacamPenyakit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_halaman_awal);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                penyakit();
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
//        Button DiagnosaPenyakit = findViewById(R.id.btn_diagnosa_penyakit);
//        Button RSTerdekat = findViewById(R.id.btn_rs_terdekat);
//        Button MacamPenyakit = findViewById(R.id.btn_macam_penyakit);
//
//        MacamPenyakit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                penyakit();
//            }
//        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_ttg, R.id.nav_pengaturan,
                R.id.nav_riwayat, R.id.nav_keluar)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

//        sharedPrefManager = new SharedPrefManager(this);
//        sharedPrefManager.saveSPInt(SharedPrefManager.SP_ID_GEJALA,ID_GEJALA);
//
//        mApiService = UtilsApi.getAPIService(); // meng-init yang ada di package apihelper
//
//        getPertanyaan();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.halaman_awal, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

//    private void getPertanyaan() {
//        mApiService.getPertanyaan(1).enqueue(new Callback<Pertanyaan>() {
//            @Override
//            public void onResponse(Call<Pertanyaan> call, final Response<Pertanyaan> response) {
//                if (response.body() != null) {
//                    Toast.makeText(HalamanAwal.this, response.body().getData().get(0).getNamaGejala(), Toast.LENGTH_LONG).show();
//                    Log.d("RETROFIT",response.body().getData().get(0).getNamaGejala());
//                } else {
//                    Toast.makeText(HalamanAwal.this, "Tidak ada respon server", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Pertanyaan> call, Throwable t) {
//                Toast.makeText(HalamanAwal.this, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
//                Log.d("RETROFIT",t.getMessage());
//            }
//        });
//    }


}
