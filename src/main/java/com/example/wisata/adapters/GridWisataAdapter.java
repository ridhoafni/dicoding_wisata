package com.example.wisata.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wisata.R;
import com.example.wisata.models.Wisata;

import java.util.ArrayList;

public class GridWisataAdapter extends RecyclerView.Adapter<GridWisataAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Wisata> listWisata;

    private ArrayList<Wisata> getGridWisata() {
        return listWisata;
    }

    public void setGridWisata(ArrayList<Wisata> listWisata) {
        this.listWisata = listWisata;
    }

    public GridWisataAdapter(Context context, ArrayList<Wisata> listWisata) {
        this.context = context;
        this.listWisata = listWisata;
    }
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_wisata, parent, false);
        return new GridViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        Glide.with(context)
                .load(getGridWisata().get(i).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(gridViewHolder.ivPhoto);
    }
    @Override
    public int getItemCount() {
        return getGridWisata().size();
    }
    public class GridViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}