package com.apkdoandroid.consumorest.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apkdoandroid.consumorest.R;
import com.apkdoandroid.consumorest.model.Foto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterFoto extends RecyclerView.Adapter<AdapterFoto.MyViewHolder> {

    List<Foto> fotos;

    public AdapterFoto(List<Foto> fotos) {
        this.fotos = fotos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_imagem,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Foto foto = fotos.get(position);
        Picasso.get().load(foto.getUrl()).into(holder.foto);

    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.imageView);
        }
    }
}
