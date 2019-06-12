package com.example.wisata.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wisata.R;
import com.example.wisata.models.Wisata;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.WisataViewHolder> {

    private Context context;
    private ArrayList<Wisata> listWisata;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Wisata> getListWisata() {
        return listWisata;
    }

    public void setListWisata(ArrayList<Wisata> listWisata) {
        this.listWisata = listWisata;
    }

    public WisataAdapter(Context context, ArrayList<Wisata> listWisata) {
        this.context = context;
        this.listWisata = listWisata;
    }

    @NonNull
    @Override
    public WisataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
        return new WisataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WisataViewHolder wisataViewHolder, int position) {
        wisataViewHolder.tvTitle.setText(getListWisata().get(position).getTitle());
        wisataViewHolder.tvDesc.setText(getListWisata().get(position).getDes());
        Glide.with(context)
                .load(getListWisata().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(wisataViewHolder.ivCover);
    }

    @Override
    public int getItemCount() {
        return getListWisata().size();
    }

    public class WisataViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_cover) ImageView ivCover;
        @BindView(R.id.tv_title) TextView tvTitle;
        @BindView(R.id.tv_desc) TextView tvDesc;
        public WisataViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
