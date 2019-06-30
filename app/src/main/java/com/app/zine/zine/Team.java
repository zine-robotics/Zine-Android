package com.app.zine.zine;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class Team extends Activity {


    @Override
    public  void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        setContentView(R.layout.team);


        /* getWindow().setLayout((int)(width),(int)(height*.4));**/
        getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams params =getWindow().getAttributes();
        params.gravity= Gravity.CENTER;
        params.x=0;
        params.y=-20;
        getWindow().setAttributes(params);


        LinearLayout menu_photos = findViewById(R.id.lv11);
        LinearLayout third=findViewById(R.id.lv12);
        LinearLayout forth=findViewById(R.id.lv13);
        menu_photos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picture_intent = new Intent(v.getContext(),Second.class);
                    startActivity(picture_intent, ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle());
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picture_intent = new Intent(v.getContext(),Third.class);
                    startActivity(picture_intent, ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle());
            }
        });
        forth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent picture_intent = new Intent(v.getContext(),Fourth.class);
                    startActivity(picture_intent, ActivityOptions.makeSceneTransitionAnimation((Activity) v.getContext()).toBundle());
            }
        });


    }
}