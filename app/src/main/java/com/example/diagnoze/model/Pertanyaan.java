package com.example.diagnoze.model;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Pertanyaan {

	@SerializedName("data")
	private List<PertanyaanItem> data;

	@SerializedName("status")
	private boolean status;

	public void setData(List<PertanyaanItem> data){
		this.data = data;
	}

	public List<PertanyaanItem> getData(){
		return data;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Pertanyaan{" +
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}