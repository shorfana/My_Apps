package com.iqbal.myapplication.view.gallery;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iqbal.myapplication.R;
import com.iqbal.myapplication.adapter.GalleryAdapter;
import com.iqbal.myapplication.model.GalleryModel;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

//    ArrayList personNames = new ArrayList<>(Arrays.asList("gambar","gambar","gambar","gambar","gambar","gambar","gambar"));
//    ArrayList personImages = new ArrayList<>(Arrays.asList(R.drawable.prayer,R.drawable.prayer,R.drawable.prayer,R.drawable.prayer,R.drawable.prayer,R.drawable.prayer,R.drawable.prayer));
    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View myFragmentView = inflater.inflate(R.layout.fragment_gallery, container, false);
        ArrayList<GalleryModel> galleryModels = new ArrayList<>();
        galleryModels.add(new GalleryModel(R.drawable.iqbal1));
        galleryModels.add(new GalleryModel(R.drawable.iqbal2));
        galleryModels.add(new GalleryModel(R.drawable.iqbal3));
        galleryModels.add(new GalleryModel(R.drawable.iqbal4));
        galleryModels.add(new GalleryModel(R.drawable.iqbal5));
        galleryModels.add(new GalleryModel(R.drawable.iqbal6));
        galleryModels.add(new GalleryModel(R.drawable.iqbal7));
        galleryModels.add(new GalleryModel(R.drawable.iqbal8));
        galleryModels.add(new GalleryModel(R.drawable.iqbal9));
        galleryModels.add(new GalleryModel(R.drawable.iqbal10));

        mRecycleView = myFragmentView.findViewById(R.id.recyclerViewGrid);
        mRecycleView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(getActivity(),3);
        mAdapter = new GalleryAdapter(galleryModels);

        mRecycleView.setLayoutManager(mLayoutManager);
        mRecycleView.setAdapter(mAdapter);
//        RecyclerView recyclerView = (RecyclerView) myFragmentView.findViewById(R.id.recyclerViewGrid);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
//        recyclerView.setLayoutManager(gridLayoutManager);
//
//        GalleryAdapter galleryAdapter = new GalleryAdapter(getActivity(),personNames,personImages);
//        recyclerView.setAdapter(galleryAdapter);
        return myFragmentView;
    }
}
