package com.iqbal.myapplication.view.profile;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.util.Util;
import com.iqbal.myapplication.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View myFragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        ImageView img = (ImageView)myFragmentView.findViewById(R.id.instagram);
        ImageView img2 = (ImageView)myFragmentView.findViewById(R.id.gmail);
        ImageView img3 = (ImageView)myFragmentView.findViewById(R.id.phone);
        Button btnMaps = (Button)myFragmentView.findViewById((R.id.btn_toMaps));
        CircleImageView imgV = (CircleImageView)myFragmentView.findViewById(R.id.circleImageView2);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent("android.intent.action.VIEW",

                        Uri.parse("https://www.instagram.com/iqballshorf/"));

                startActivity(browserIntent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "iqbalshorfana@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Halo");
                intent.putExtra(Intent.EXTRA_TEXT, "Saya ingin Mengundang anda untuk bekerja");
                startActivity(Intent.createChooser(intent, ""));
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String formattedNumber = "0895372111373";
                try{
                    Intent sendIntent =new Intent("android.intent.action.MAIN");
                    sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.setType("text/plain");
                    sendIntent.putExtra(Intent.EXTRA_TEXT,"");
                    sendIntent.putExtra("jid", formattedNumber +"@s.whatsapp.net");
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                }
                catch(Exception e)
                {
                        Toast.makeText(myFragmentView.getContext(),"Error/n"+ e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/search/?api=1&query=-6.8856043,107.6139917"));
                startActivity(intent);
            }
        });

        imgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/search/?api=1&query=-6.8856043,107.6139917"));
                startActivity(intent);
            }
        });

        return myFragmentView;
    }
}
