package com.iqbal.myapplication.model;

public class DailyModel {
    private int mImageResource;
    private String namaGambar;

    public DailyModel(int ImageResource, String namagambar){
        mImageResource = ImageResource;
        namaGambar = namagambar;

    }

    public int getmImageResource(){
        return mImageResource;
    }

    public String getNamaGambar(){
        return namaGambar;
    }

}
