package com.iqbal.myapplication.model;

public class MusicModel {
    private int musicResource;
    private String namaMusic;

    public MusicModel(int musicResource, String namaMusic) {
        this.musicResource = musicResource;
        this.namaMusic = namaMusic;
    }

    public int getMusicResource() {
        return musicResource;
    }

    public void setMusicResource(int musicResource) {
        this.musicResource = musicResource;
    }

    public String getNamaMusic() {
        return namaMusic;
    }

    public void setNamaMusic(String namaMusic) {
        this.namaMusic = namaMusic;
    }
}
