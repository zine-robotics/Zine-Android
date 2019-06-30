package com.app.zine.zine;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.Objects;

public class Third extends AppCompatActivity {

    ListView listView;
    String[] cn={"Saksham","Devnath","Meenal","Nimesh","Rohan","Tejeshwar","Vikalp","Tarushree"};
    String[] cb={"CSE","ME","CE","ME","ECE","CSE","ME","EE"};
    String[] cm={"8824290619","9636080788","9478789319","8504830730","9672139192","7424825250","9045245993","9409467184"};

    Integer[] imageid={

            R.drawable.saksham,
            R.drawable.devnath,
            R.drawable.meenal,
            R.drawable.nimesh,
            R.drawable.rohan,
            R.drawable.tb,
            R.drawable.vikalp,
            R.drawable.tarushree,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Third Year");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(toolbar.getNavigationIcon()).setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Teamadapter adapter = new Teamadapter(Third.this,cn,cb,cm,imageid);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

}
