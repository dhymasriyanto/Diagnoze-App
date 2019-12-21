package com.example.diagnoze;

import android.net.Uri;

import java.util.ArrayList;

public class DataPenyakit {
    public static String[][] demaam = new String[][]{
            // gbr, nama, gejala, pengobatan, pencegahan
            {DataPenyakit.getDrawable(R.drawable.demam_hemorargik),"Demam Hemorargik","Obat Ribavirin","Wajah dan dada yang memerah","Menghindari gigitan caplak"},
            {DataPenyakit.getDrawable(R.drawable.demam_tbc),"Demam TBC","Obat Rsoniazid, Obat Rifampicin, Obat Pyrazinamide dan Ethambutol","Nyeri pada dada, dan keringat pada malam hari","vaksin BCG (Bacillus Calmette-Guerin)"},
            {DataPenyakit.getDrawable(R.drawable.demam_tifoid),"Demam Tifoid","Paracetamol","Otot terasa sakit","Vaksin tifoid"},
            {DataPenyakit.getDrawable(R.drawable.dengue),"Demam Berdarah Dengue","Paracetamol","Sakit Kepala, Nyeri pada bagian belakang mata","Menguras bak mandi seminggu sekali dan Menguras bak Mandi"},
            {DataPenyakit.getDrawable(R.drawable.flu),"Demam Flu","Influenza","Batuk kering, Sesekali sakit tenggorokan, Badan gemetar, Menggigil","Menjauhkan diri dulu dari orang lain, hingga setidaknya 24 jam setelah demam turun, Memakai masker bila ke luar rumah, Menutup mulut dan hidung dengan tisu saat bersin atau batuk"},
            {DataPenyakit.getDrawable(R.drawable.malaria),"Demam Malaria","Artemisin-based combination therapies (ACT)","Menggigil sedang sampai berat, Tubuh kelelahan, Banyak berkeringat, Sakit kepala","Pemberian terapi berbasis artemisinin (ACT)"},
            {DataPenyakit.getDrawable(R.drawable.radang_paru_paru),"Demam Radang Paru-Paru","Antibiotik","Demam, mual dan muntah, Sesak napas dan lemas, Diare dan Selera Makan Menurun, Berkeringat dan Menggigil.","Harus Memiliki/Makan Gizi Yang Cukup"},
            {DataPenyakit.getDrawable(R.drawable.septik),"Demam Septik","Antibiotik, Operasi, Arthrocentesis, sedangkan Fisioterapi akan membantu sendi bergerak dengan normal lagi","pembengkakan pada sendi yang cepat, sangat sakit, Menggigil, nyeri otot, dan kelelahan","Pemberian oksigen dan alat bantu pernapasan"},
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