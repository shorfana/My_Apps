package com.iqbal.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.iqbal.myapplication.R;
import com.iqbal.myapplication.model.GalleryModel;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private ArrayList<GalleryModel> mGalleryModel;
    Context context;

    public GalleryAdapter(ArrayList<GalleryModel> mGalleryModel) {
        this.mGalleryModel = mGalleryModel;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_grid_row,viewGroup,false);
        GalleryViewHolder va = new GalleryViewHolder(v);
        return va;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder galleryViewHolder, int position) {
        final GalleryModel currentItem = mGalleryModel.get(position);
        galleryViewHolder.mImageView.setImageResource(currentItem.getImageResource());


    }

    @Override
    public int getItemCount() {
        return mGalleryModel.size();
    }

    public static class GalleryViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;


        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageGrid);
        }
    }

}
