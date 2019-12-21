package com.example.diagnoze.Rest;

//import apps.rez.com.smartguru.Models.DataKelas;
//import apps.rez.com.smartguru.Models.DataKelasDetail;
//import apps.rez.com.smartguru.Models.DataSiswa;
//import apps.rez.com.smartguru.Models.DataSiswaKelas;
import com.example.diagnoze.model.Pertanyaan;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BaseApiService {
    @FormUrlEncoded
    @POST("auth")
    Call<ResponseBody> authLogin(@Field("username") String username,
                                 @Field("password") String password);

    @GET("Penyakit/pertanyaan")
    Call<Pertanyaan> getPertanyaan(@Query("idGejala") int idGejala);


    @FormUrlEncoded
    @POST("Penyakit/penyakit")
    Call<ResponseBody> penyakit(@Field("gejala") String gejala);


}