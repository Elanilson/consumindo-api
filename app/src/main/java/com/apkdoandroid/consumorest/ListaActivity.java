package com.apkdoandroid.consumorest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.apkdoandroid.consumorest.adapter.AdapterFoto;
import com.apkdoandroid.consumorest.api.DataService;
import com.apkdoandroid.consumorest.model.Foto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterFoto adapter;
    private List<Foto> fotos = new ArrayList<>();
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        recyclerView = findViewById(R.id.recyclerView);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        carregarFotos();


    }

    private void configuracaoRecycleview() {

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new AdapterFoto(fotos);
//        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

    }

    private void carregarFotos() {
        DataService service = retrofit.create(DataService.class);
        Call<List<Foto>> call = service.carregarFoto();
        call.enqueue(new Callback<List<Foto>>() {
            @Override
            public void onResponse(Call<List<Foto>> call, Response<List<Foto>> response) {
                if(response.isSuccessful()){
                    fotos = response.body();
                    configuracaoRecycleview();

                }
            }

            @Override
            public void onFailure(Call<List<Foto>> call, Throwable t) {

            }
        });
    }

}