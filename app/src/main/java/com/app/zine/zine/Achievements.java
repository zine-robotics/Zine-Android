package com.app.zine.zine;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Objects;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class Achievements extends AppCompatActivity {

    int[] image_array = new int[]{
            R.layout.ac20,
            R.layout.ac16,
            R.layout.ac3,
            R.layout.ac21,
            R.layout.ac1,
            R.layout.ac11,
            R.layout.ac9,
            R.layout.ac7,
            R.layout.ac17,
            R.layout.ac4,
            R.layout.ac8,
            R.layout.ac2,
            R.layout.ac10,
            R.layout.ac12,
            R.layout.ac14,
            R.layout.ac5,
            R.layout.ac15,
            R.layout.ac13,
            R.layout.ac18,
            R.layout.ac19,
            R.layout.ac6,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.achievements);

        FeatureCoverFlow coverFlow;
        MovieAdapter movieAdapter;
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Achievements");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(toolbar.getNavigationIcon()).setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        movieAdapter=new MovieAdapter(this,image_array);
        coverFlow=findViewById(R.id.coverflow);

        coverFlow.setAdapter(movieAdapter);


    }

}
