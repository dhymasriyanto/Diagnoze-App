package com.example.diagnoze;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridPenyakit extends RecyclerView.Adapter<GridPenyakit.GridViewHolder> {
    private ArrayList<Penyakit> listPenyakit;
    private OnItemClickCallback onItemClickCallback;

    public GridPenyakit(ArrayList<Penyakit> list) {
        this.listPenyakit = list;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_macam_penyakit, parent,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listPenyakit.get(position).getGambar())
                .apply(new RequestOptions().override(350,250))
                .into(holder.imgPhoto);
        holder.nama.setText(listPenyakit.get(position).getNama_penyakit());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listPenyakit.get(holder.getAdapterPosition()));
            }
        });
        

    }

    @Override
    public int getItemCount() {
        return listPenyakit.size();
    }
    // INI CLASS UNTUK MACAM PENYAKIT


    class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView nama;

        public GridViewHolder( View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.item_photo);
            nama = itemView.findViewById(R.id.item_nama);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Penyakit data);
    }
}
