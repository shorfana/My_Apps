package com.iqbal.myapplication.model;

// Tanggal Pengerjaan : 2 mei 2019
// NIM                : 10116465
// Nama               : Muhammad Iqbal Shorfana
// Kelas              : AKB 11

public class FriendsModel {
    private int mImageResource;
    private String namaGambar;

    public FriendsModel(int ImageResource, String namagambar){
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
