package com.app.zine.zine;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.Objects;

public class Second extends AppCompatActivity {

    ListView listView;
    String[] cn={"Tanishk","Vishal","Paarth","Akarth","Tanmay","Vibhor","Keshav","Sumit"};
    String[] cb={"ME","ECE","ECE","ECE","ECE","CSE","ECE","CSE"};
    String[] cm={"8947892024","9909435279","9871856190","8529539248","9680389686","7053559011","7073474054","9812244847"};

    Integer[] imageid={
            R.drawable.tanishk,
            R.drawable.vish,
            R.drawable.paarth,
            R.drawable.akarth,
            R.drawable.tanmay,
            R.drawable.vibhor,
            R.drawable.keshav,
            R.drawable.sumit,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_layout);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Second Year");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(toolbar.getNavigationIcon()).setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Teamadapter adapter = new Teamadapter(Second.this,cn,cb,cm,imageid);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);


    }


}
