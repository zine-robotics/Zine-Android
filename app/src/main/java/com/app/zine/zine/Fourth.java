package com.app.zine.zine;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.Objects;

public class Fourth extends AppCompatActivity {

    ListView listView;
    String[] cn={"Divyam","Kriti","Md. Saif","Piyush","Puru Lokendra","Mrigakshi","Samidha","Vasanth",};
    String[] cb={"EE","CSE","EE","ECE","EE","ECE","EE","EE",};
    String[] cm={"9472145687","9828042882","7823029240","9434140058","9530456548","7240059193","8696438363","8769691559",};

    Integer[] imageid={
            R.drawable.divyam,
            R.drawable.kriti,
            R.drawable.saif,
            R.drawable.piyush,
            R.drawable.puru,
            R.drawable.mp,
            R.drawable.samidha,
            R.drawable.vasanth,

    };



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_layout);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Fourth Year");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(toolbar.getNavigationIcon()).setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Teamadapter adapter = new Teamadapter(Fourth.this,cn,cb,cm,imageid);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

}
