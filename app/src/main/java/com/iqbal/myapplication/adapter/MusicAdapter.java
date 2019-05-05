package com.iqbal.myapplication.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.iqbal.myapplication.R;
import com.iqbal.myapplication.model.MusicModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder>{
    private Context context;
    List<MusicModel> musicModelList;
    private ArrayList<Integer> newMusic= new ArrayList<>();

    public MusicAdapter(Context context, List<MusicModel> musicModelList) {
        this.context = context;
        this.musicModelList = musicModelList;
    }

    public static class MusicViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtMusicTitle)
        TextView txtMusicTitle;
        @BindView(R.id.txtMusicArtist)
        TextView txtMusicArtist;
        @BindView(R.id.txtMusicDuration)
        TextView txtMusicDuration;
        @BindView(R.id.imgMusic)
        ImageView imgMusic;
        private static MediaPlayer mediaPlayer;
        private ArrayList<Integer> musicModel=new ArrayList<>();

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setItem(ArrayList<Integer> item){
            musicModel=item;
        }

        @OnClick
        void onClick(@NonNull View itemView){
            int position=getAdapterPosition();
            int uri=musicModel.get(position);
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                mediaPlayer.release();
                mediaPlayer = null;
                Toast.makeText(itemView.getContext(),"Stopping",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(itemView.getContext(),"Playing",Toast.LENGTH_LONG).show();
                mediaPlayer = MediaPlayer.create(itemView.getContext(), uri);
                mediaPlayer.start();
            }


        }
    }


    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.audio_type,viewGroup,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder musicViewHolder, int i) {
        MusicModel musicModel=musicModelList.get(i);
        musicViewHolder.txtMusicTitle.setText(musicModel.getTitle());
        musicViewHolder.txtMusicArtist.setText(musicModel.getArtist());
        musicViewHolder.txtMusicDuration.setText(musicModel.getDuration());
        musicViewHolder.imgMusic.setImageResource(musicModel.getImage());

        int uri=musicModel.getPath();
        newMusic.add(uri);
        musicViewHolder.setItem(newMusic);
    }

    @Override
    public int getItemCount() {
        return musicModelList.size();
    }


}
