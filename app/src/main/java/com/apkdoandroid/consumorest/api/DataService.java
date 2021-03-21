package com.apkdoandroid.consumorest.api;

import com.apkdoandroid.consumorest.model.Foto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("/photos")
    Call<List<Foto>> carregarFoto();
}
