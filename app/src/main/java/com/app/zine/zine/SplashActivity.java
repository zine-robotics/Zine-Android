package com.app.zine.zine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.felipecsl.gifimageview.library.GifImageView;
import com.google.android.gms.common.util.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashActivity extends AppCompatActivity {

    GifImageView gifView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        gifView = findViewById(R.id.gifImageView);
        try{
            InputStream inputStream=getAssets().open("blink.gif");
            byte[] bytes= IOUtils.toByteArray(inputStream);
            gifView.setBytes(bytes);
            gifView.startAnimation();
        }
        catch (IOException ex)
        {

        }


        ImageView zoom = findViewById(R.id.imageview);
        Animation zoomAnimation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.zoom);
        zoom.startAnimation(zoomAnimation);

        zoomAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Handler mHandler = new Handler(getMainLooper());
                Runnable mRunnable = new Runnable() {
                    @Override
                    public void run() {
                        finish();
                        Intent i = new Intent(SplashActivity.this,MainActivity.class);

                        startActivity(i);
                        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);

                    }
                };
                mHandler.postDelayed(mRunnable, 2000);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        android.os.Process.killProcess(android.os.Process.myPid());
    }

}

