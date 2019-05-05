package com.iqbal.myapplication.view;

// Tanggal Pengerjaan : 25 april 2019
// NIM                : 10116465
// Nama               : Muhammad Iqbal Shorfana
// Kelas              : AKB 11

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.iqbal.myapplication.R;
import com.iqbal.myapplication.view.daily.DailyFragment;
import com.iqbal.myapplication.view.gallery.GalleryFragment;
import com.iqbal.myapplication.view.home.HomeFragment;
import com.iqbal.myapplication.view.music.MusicFragment;
import com.iqbal.myapplication.view.profile.ProfileFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());
    }

    void loadFragment(Fragment fragment){
        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container,fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.navigation_home:
                loadFragment(new HomeFragment());
                return  true;
            case R.id.navigation_daily:
                loadFragment(new DailyFragment());
                return  true;
            case R.id.navigation_galery:
                loadFragment(new GalleryFragment());
                return  true;
            case R.id.navigation_music:
                loadFragment(new MusicFragment());
                return  true;
            case R.id.navigation_profile:
                loadFragment(new ProfileFragment());
                return  true;

        }
        return false;
    }
}
