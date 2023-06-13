package com.example.diagnoze.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class PertanyaanItem {

	@SerializedName("nama_gejala")
	private String namaGejala;

	public void setNamaGejala(String namaGejala){
		this.namaGejala = namaGejala;
	}

	public String getNamaGejala(){
		return namaGejala;
	}

	@Override
 	public String toString(){
		return 
			"PertanyaanItem{" +
			"nama_gejala = '" + namaGejala + '\'' + 
			"}";
		}
}