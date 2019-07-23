package com.app.zine.zine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ThirdYear extends Fragment {

    ListView listView;
    String[] cn={"Tanishk Dudi","Vishal Kothari","Paarth Bir","Akarth Gupta","Tanmay Agarwal","Vibhor Rawal","Keshav Sarraf","Sumit Soni","Pranav Kulshrestha"};
    String[] cb={"ME","ECE","ECE","ECE","ECE","CSE","ECE","CSE","EE"};
    String[] cm={"8947892024","9909435279","9871856190","8529539248","9680389686","7053559011","7073474054","9812244847","9079650989"};


    Integer[] imageid={
            R.drawable.tanishk,
            R.drawable.vish,
            R.drawable.paarth,
            R.drawable.akarth,
            R.drawable.tanmay,
            R.drawable.vibhor,
            R.drawable.keshav,
            R.drawable.sumit,
            R.drawable.pranav
    };

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
            View root = inflater.inflate(R.layout.team_layout, viewGroup, false);


            listView = root.findViewById(R.id.list_view);

        Teamadapter adapter = new Teamadapter(getActivity(),cn,cb,cm,imageid);
        listView.setAdapter(adapter);




            return root;
        }
    }