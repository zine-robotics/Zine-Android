package com.app.zine.zine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FourthYear extends Fragment {

    ListView listView;
    String[] cn={"Devnath Nair","Nimesh Khandelwal","Vikalp Saini"};
    String[] cb={"ME","ME","ME"};
    String[] cm={"9636080788","8504830730","9045245993"};

    Integer[] imageid={

            R.drawable.devnath,
            R.drawable.nim,
            R.drawable.vikalp,
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