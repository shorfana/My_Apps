package com.iqbal.myapplication.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.iqbal.myapplication.R;
import com.iqbal.myapplication.model.VideoModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    private Context context;
    List<VideoModel> videoModelList;
    private ArrayList<VideoView> newVideo= new ArrayList<>();

    public static class VideoViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.txtVideoTitle)
        TextView txtVideoTitle;
        @BindView(R.id.video)
        VideoView video;
        private ArrayList<VideoView> videoModel=new ArrayList<>();
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        public void setItem(ArrayList<VideoView> item){
            videoModel=item;
        }

        @OnClick
        void onClick(@NonNull View itemView){
            int position=getAdapterPosition();
            videoModel.get(position).start();
        }
    }

    public VideoAdapter(Context context, List<VideoModel> videoModelList) {
        this.context = context;
        this.videoModelList = videoModelList;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.video_type,viewGroup,false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        VideoModel videoModel=videoModelList.get(i);
        videoViewHolder.txtVideoTitle.setText(videoModel.getTitle());
        videoViewHolder.video.setVideoURI(Uri.parse(videoModel.getPath()));
        newVideo.add(videoViewHolder.video);
        videoViewHolder.setItem(newVideo);
    }

    @Override
    public int getItemCount() {
        return videoModelList.size();
    }
}
