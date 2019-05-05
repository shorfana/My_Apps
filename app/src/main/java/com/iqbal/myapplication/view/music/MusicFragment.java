package com.iqbal.myapplication.view.music;

// Tanggal Pengerjaan : 4 mei 2019
// NIM                : 10116465
// Nama               : Muhammad Iqbal Shorfana
// Kelas              : AKB 11

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.iqbal.myapplication.R;
import com.iqbal.myapplication.adapter.MusicAdapter;
import com.iqbal.myapplication.adapter.VideoAdapter;
import com.iqbal.myapplication.model.MusicModel;
import com.iqbal.myapplication.model.VideoModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MusicFragment extends Fragment {
    //deklarasi musik
    RecyclerView rvMusic;
    List<MusicModel> musicModelList;

    //deklarasi video
    RecyclerView rvVideo;
    List<VideoModel> videoModelList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View myFragmentView = inflater.inflate(R.layout.fragment_music, container, false);
        View viewFragment=inflater.inflate(R.layout.fragment_music, container, false);
        ButterKnife.bind(this,viewFragment);
        int musik1=R.raw.googoodollsiris;
        int musik2=R.raw.simpleplansummerparadiseftseanpaul;
        int musik3=R.raw.thescriptthemanwhocantbemoved;
        int musik4=R.raw.trainheysoulsister;

        musicModelList=new ArrayList<>();
        musicModelList.add(new MusicModel(1,R.drawable.song,"Goo Go Dolls","Iris","3.36", musik1));
        musicModelList.add(new MusicModel(2,R.drawable.song,"Simple PLan","Summer Paradise","04.03", musik2));
        musicModelList.add(new MusicModel(3,R.drawable.song,"The Man who can`t be moved","the script","04.00", musik3));
        musicModelList.add(new MusicModel(6,R.drawable.song,"Hey Soul Sister","Train","3.38", musik4));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rvMusic = myFragmentView.findViewById(R.id.music_r);
        rvMusic.setLayoutManager(linearLayoutManager);
        rvMusic.setHasFixedSize(true);
        MusicAdapter musicAdapter =new MusicAdapter(getContext(), musicModelList);
        rvMusic.setAdapter(musicAdapter);

        //for video
        String pathVideo = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.alkahfiayat1;

        LinearLayoutManager vLinearLayoutManager=new LinearLayoutManager(getContext());
        videoModelList=new ArrayList<>();
        videoModelList.add(new VideoModel(1,"Gunung Cikuray","Ambigu Squad","0.20", pathVideo));
        videoModelList.add(new VideoModel(2,"Al Kahfi ayat 1","M Iqbal Shorfana","0.20", pathVideo));
        rvVideo = myFragmentView.findViewById(R.id.video_r);
        rvVideo.setLayoutManager(vLinearLayoutManager);
        rvVideo.setHasFixedSize(true);
        VideoAdapter videoAdapter =new VideoAdapter(getContext(), videoModelList);
        rvVideo.setAdapter(videoAdapter);

        return myFragmentView;
    }
}
