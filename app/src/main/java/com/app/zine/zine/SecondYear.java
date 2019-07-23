package com.app.zine.zine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondYear extends Fragment {

    ListView listView;
    String[] cn={"Akash Gupta","Bhanu Mohindra","Brijraj Jangir","Charu","Dhruv Goyal","Harsh Chaudhary","Kshitiz Kamal","Muskan Garg","Nikita Rautela","Pravesh Sandhu","Rajat Agrawal","Saransh Tayal","Sneha Yadav","Vaibhav Agrawal"};
    String[] cb={"CSE","ME","ME","CH","CSE","ME","CE","CE","ME","CSE","EE","CH","EE","CSE"};
    String[] cm={"9009546537","7625803158","9680519394","7087488948","9529295390","7378382467","8948239724","8739912154",
            "8941078579","7688962347","8619622895","9910829462","9870283380","7089949982"};

    Integer[] imageid={
            R.drawable.akash,
            R.drawable.bhanu,
            R.drawable.birju,
            R.drawable.charu,
            R.drawable.dhruv,
            R.drawable.harsh,
            R.drawable.kshitiz,
            R.drawable.muskan,
            R.drawable.nikita,
            R.drawable.pravesh,
            R.drawable.rajat,
            R.drawable.saransh,
            R.drawable.sneha,
            R.drawable.vaibhav
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