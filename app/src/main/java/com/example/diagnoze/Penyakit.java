package com.example.diagnoze;

import android.os.Parcel;
import android.os.Parcelable;

public class Penyakit implements Parcelable {
    String gambar;
    String nama_penyakit;
    String gejala;
    String pengobatan;
    String cara_mengatasi;

    protected Penyakit(Parcel in) {
        gambar = in.readString();
        nama_penyakit = in.readString();
        gejala = in.readString();
        pengobatan = in.readString();
        cara_mengatasi = in.readString();
    }

    public static final Creator<Penyakit> CREATOR = new Creator<Penyakit>() {
        @Override
        public Penyakit createFromParcel(Parcel in) {
            return new Penyakit(in);
        }

        @Override
        public Penyakit[] newArray(int size) {
            return new Penyakit[size];
        }
    };

    public Penyakit() {

    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama_penyakit() {
        return nama_penyakit;
    }

    public void setNama_penyakit(String nama_penyakit) {
        this.nama_penyakit = nama_penyakit;
    }

    public String getGejala() {
        return gejala;
    }

    public void setGejala(String gejala) {
        this.gejala = gejala;
    }

    public String getPengobatan() {
        return pengobatan;
    }

    public void setPengobatan(String pengobatan) {
        this.pengobatan = pengobatan;
    }

    public String getCara_mengatasi() {
        return cara_mengatasi;
    }

    public void setCara_mengatasi(String cara_mengatasi) {
        this.cara_mengatasi = cara_mengatasi;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(gambar);
        parcel.writeString(nama_penyakit);
        parcel.writeString(gejala);
        parcel.writeString(pengobatan);
        parcel.writeString(cara_mengatasi);
    }
}
