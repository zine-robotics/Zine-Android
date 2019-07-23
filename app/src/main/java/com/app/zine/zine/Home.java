package com.app.zine.zine;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Home extends Fragment {

    LinearLayout lteam,lworkshop,lach,lpro;
    View vt;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        vt = super.getView();
        assert vt != null;
        lteam=vt.findViewById(R.id.lv11);
        lworkshop = vt.findViewById(R.id.ll2);
        lach=vt.findViewById(R.id.lv12);
        lpro=vt.findViewById(R.id.ll1);
        lteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),TeamActivity.class);

                 startActivity(i);
           }
        });
        lworkshop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),Workshop.class);
                startActivity(i);
            }
        });
        lach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),Achievements.class);
                startActivity(i);
            }
        });
        lpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(v.getContext(),Project.class);
                startActivity(i);
            }
        });
        super.onViewCreated(view, savedInstanceState);


    }

    public void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);

    }
}
