package com.example.diagnoze;

import android.net.Uri;

import java.util.ArrayList;

public class DataPenyakit {
    public static String[][] demaam = new String[][]{
            // gbr, nama, gejala, pengobatan, pencegahan
            {DataPenyakit.getDrawable(R.drawable.picture1),"demam 1","pengobatan 1","gejala 1","pengobatan 1"},
            {DataPenyakit.getDrawable(R.drawable.picture1),"demam 2","pengobatan 2","gejala 2","pengobatan 1"},
            {DataPenyakit.getDrawable(R.drawable.picture1),"demam 3","pengobatan 3","gejala 3","pengobatan 1"},
            {DataPenyakit.getDrawable(R.drawable.picture1),"demam 4","pengobatan 4","gejala 4","pengobatan 1"},
            {DataPenyakit.getDrawable(R.drawable.picture1),"demam 5","pengobatan 5","gejala 1","pengobatan 1"},
            {DataPenyakit.getDrawable(R.drawable.picture1),"demam 6","pengobatan 6","gejala 1","pengobatan 1"},
            {DataPenyakit.getDrawable(R.drawable.picture1),"demam 7","pengobatan 7","gejala 1","pengobatan 1"},
            {DataPenyakit.getDrawable(R.drawable.picture1),"demam 8","pengobatan 8","gejala 1","pengobatan 1"},
    };

    private static String getDrawable(int resourceId){
        return Uri.parse("android.resource://"+R.class.getPackage().getName() + "/" + resourceId).toString();
    }

    public static ArrayList<Penyakit> getListData(){
        ArrayList<Penyakit> list = new ArrayList<>();
        for (String[] demam : demaam ){
            Penyakit p = new Penyakit();
            p.setGambar(demam[0]);
            p.setNama_penyakit(demam[1]);
            p.setGejala(demam[2]);
            p.setPengobatan(demam[3]);
            p.setCara_mengatasi(demam[4]);
            list.add(p);
        }
        return list;
    }
}