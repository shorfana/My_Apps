package com.iqbal.myapplication.view.home;
// Tanggal Pengerjaan : 28 april 2019
// NIM                : 10116465
// Nama               : Muhammad Iqbal Shorfana
// Kelas              : AKB 11
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iqbal.myapplication.R;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }
}
